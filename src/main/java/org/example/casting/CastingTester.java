package org.example.casting;

public class CastingTester {
    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.readLogs();

        Manager manager = new Manager();
        manager.addUsers();


        // casting

        //Upcasting. <=> IS-A-REL
        Role role = new GeneralUser();
        role.read();

        Object o = new GeneralUser();
        //o.read();

        //
        Role role1 = (Role) new Manager();
        Object o1 = (Object)(Role) new Manager();

        Admin admin1 = new Admin();
        Role role2 = (Role)admin1;
        Object o2 = role2;

       test("");
        test(o2);
        test(o1);
        test(123); // (Object) new Integer(123)

        Object[] objects = {new DVDPlayer(),
                (Player)new Mp3Player(),
                new TapePlayer(), new Mp3Player()};

        for(Object obj : objects){
            test(obj);
            if(obj instanceof Player){
                ((Player)obj).play();

                if(obj instanceof Mp3Player){
                    ((Mp3Player)obj).addSong();
                }
            }





        }

        // Down casting.
        System.out.println("======= Down casting ======");
       // String str = (String) new Object();

       // Role role3 = (Role)new DVDPlayer();

        Role r = (Role) new Admin();

        //
        if(r instanceof Admin){
            Admin a  = (Admin) r;
            a.readLogs();
            if(a instanceof SuperAdmin){
                SuperAdmin su = (SuperAdmin)a;
                su.canDoAllStuff();
            }
        } else if(r instanceof Manager){
            Manager m  = (Manager) r;
            m.addUsers();
        } else {
            GeneralUser gu = (GeneralUser) r;
            gu.createOrder();
        }

    }

    static void test(Object obj){
        System.out.println(obj.getClass().getSimpleName());
    }


}


abstract class Player {
    abstract void play();
}

class DVDPlayer extends Player {



    @Override
    void play() {
        System.out.println("playing disc");
    }
}
class Mp3Player extends Player{

    void addSong(){
        System.out.println("addSong");
    }


    @Override
    void play() {
        System.out.println("playing songs from internal storage");
    }
}

class TapePlayer extends  Player {



    @Override
    void play() {
        System.out.println("playing songs from Tape");
    }
}

