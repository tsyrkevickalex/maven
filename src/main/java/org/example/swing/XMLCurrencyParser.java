package org.example.swing;

import org.example.io.xlsx.Currency;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XMLCurrencyParser {

    private static String CURRENCY_URL = "https://www.nbrb.by/Services/XmlExRates.aspx";

    private static Document loadDocument(String url) {
        Document doc = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        try {
            doc = factory.newDocumentBuilder().parse(new URL(url).openStream());
        } catch (ConnectException e) {
            System.err.print(" Oops! Something goes wrong! This is Belarus, baby! \nConnection timed out. ");
            System.err.print( CURRENCY_URL + " is not responsible. Please, try again later");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return doc;
    }

    /**
     * Parse www.nbrb.by source Service to search for the requested rate.<br><br>
     * Currency codes are composed of a country's two-character Internet country
     * code plus a third character denoting the currency unit. For example, the
     * Canadian Dollar code (CAD) is made up of Canada's Internet code ("CA")
     * plus a currency designator ("D").
     *
     * @param currencyCode - Currency code
     * @return String - value of requested currency
     * @see <a href="https://en.wikipedia.org/wiki/ISO_4217">ISO 4217 code list</a>
     * @author Alex Sharlan
     */
    public static String getCurrency(String currencyCode) {
        boolean isCurrencyCodeNext = false;
        Document doc  = loadDocument(CURRENCY_URL);

        if (doc != null) {
            NodeList nodes = doc.getFirstChild().getChildNodes();
            Node parent, child;

            for (int i = 0; i < nodes.getLength(); i++) {
                parent = nodes.item(i);

                if (parent.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList childs = parent.getChildNodes();

                    for (int ii = 0; ii < childs.getLength(); ii++) {
                        child = childs.item(ii);
                        if (child.hasChildNodes()) {
                            if (child.getNodeName().trim().equalsIgnoreCase("Rate") && isCurrencyCodeNext) {
                                isCurrencyCodeNext = false;
                                return child.getFirstChild().getTextContent();
                            }

                            if (child.getFirstChild().getTextContent().trim().equalsIgnoreCase(currencyCode)) {
                                isCurrencyCodeNext = true;
                            }
                        }
                    }
                }
            }
        }
        return "0.0";
    }




    public static Currency getCurrencyObject(String currencyCode) {
        boolean isCurrencyCodeNext = false;
        Document doc  = loadDocument(CURRENCY_URL);
        Currency currency = null;

        if (doc != null) {
            currency = new Currency();
            NodeList nodes = doc.getFirstChild().getChildNodes();
            Node parent, child;

            for (int i = 0; i < nodes.getLength(); i++) {
                parent = nodes.item(i);

                if (parent.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList childs = parent.getChildNodes();

                    for (int ii = 0; ii < childs.getLength(); ii++) {
                        child = childs.item(ii);
                        if (child.hasChildNodes()) {
                            if (child.getNodeName().trim().equalsIgnoreCase("Rate") && isCurrencyCodeNext) {
                                isCurrencyCodeNext = false;
                                currency.setRate(Double.valueOf(child.getFirstChild().getTextContent().trim()));


                            }

                            if (child.getFirstChild().getTextContent().trim().equalsIgnoreCase(currencyCode)) {
                                isCurrencyCodeNext = true;

                            }
                        }
                    }
                }
            }
        }
        return currency;
    }

    public static List<Currency> getMainCurrencies(){
        List<Currency> currencies = new ArrayList<>();
        currencies.add(getCurrencyObject("USD"));
        currencies.add(getCurrencyObject("EUR"));
        currencies.add(getCurrencyObject("RUB"));
        return currencies;
    }


    public static void main(String[] args) {// TEST

//        System.out.println(getCurrency("EUR"));
//        double usdRate = Double.valueOf(getCurrency("EUR"));
//        usdRate = usdRate + (usdRate* 0.05);
//        System.out.println(usdRate);
//
//        Currency currency = getCurrencyObject("USD");
//        System.out.println();

//        for (Currency c: getMainCurrencies()) {
//            System.out.println(c);
//        }
        //1. Get Currencies
        List<Currency> currencies = XMLCurrencyParser.getMainCurrencies();

        //2. Save all currencies in XLSX
        Currency.writeCurrency("D:\\currencies_table_"+new Date().getTime()+".xlsx", currencies);

        //3. Send file to email
    }
}
