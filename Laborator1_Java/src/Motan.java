
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

public class Motan {
    String name;
    float mass;// 0.. 15
    byte fur; //0..10 in dependenta de cat de pufos este
    int pics;//nr picaturi de valeriana
    int info[];//1- sus, 2- jos, 3- la stînga, 4- la dreapta

    static int nr;// nr de obiecte create

    //Constructori////
    Motan() { // implicit
        name = "Ciki";
        pics = 15;
        info = new int[pics]; //alocam memorie pentru vector-tipul elem este int,nr =pics
        for (int i = 0; i < pics; i++) //prin ciclu umplem vectorul cu 2. Variabila ciclului - i
            info[i] = 2;
        mass = (float) 2.5;
        fur = (byte) 7;
        nr++;   //dacă este chemat constructorul => a fost creat un obiect => numărul obiectelor (nr) crește

    }

    Motan(String name, int pics) { //cu 2 parametri
        this.name = name;   //pentru a face diferența dintre numele parametrului și cîmpul clasei, folosim this
        this.pics = pics;
        info = new int[pics];
        for (int i = 0; i < pics; i++)
            info[i] = 3;
        mass = (float) 2.5;
        fur = (byte) 7;
        nr++;
    }

    Motan(Motan Prototip) { // constructorul de copiere este obligat să copie TOATE cîmpurile obiectului-parametru Prototip
        name = Prototip.name;
        pics = Prototip.pics;
        info = new int[Prototip.pics];   // alocăm memorie pentru vectorul info – tipul elementelor este int, numărul lor = Prototip.pics
        for (int i = 0; i < Prototip.pics; i++)
            info[i] = Prototip.info[i];
        mass = Prototip.mass;
        fur = Prototip.fur;
        nr++;                            // dacă este chemat constructorul => a fost creat un obiect => numărul obiectelor (nr) crește
    }


    ////////////////////metode de acces la campurile clasei(get_*) si (set)//////////////////////
    public String getName() {     // accesul la cîmpul clasei name – returnează copia valorii cîmpului dat
        return name;              // return this.name
    }

    public void setName(String newName) {   //setează în cîmpului clasei name valoarea nouă a parametrului new_name
        name = newName;                     // this.name = new_name;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float newMass) { //verificam daca masa se incadreaza in parametri nostri

        if (newMass >= 0 && newMass <= 15)  // înainte de a folosi parametrul newMass, îi controlăm corectitudinea
            mass = newMass;                    // daca este corect, introducem valoarea lui în Mass
    }

    public byte getFur() {
        return fur;
    }

    public void setFur(byte newFur) {
        if (newFur > 0 && newFur < 11)
            fur = newFur;

    }

    public int getPics() {
        return pics;
    }

    public void setPics(int newPics) {
        //avem grija sa nu pierdem datele despre picaturile anterioare inainte de a le schimba numarul
        if (newPics > 0 && newPics < 100 && newPics != pics) {
            int[] tmp = new int[pics];
            for (int i = 0; i < pics; i++) {
                tmp[i] = info[i];//Copiam datele despre toate picaturile anterioare
            }
            info = new int[newPics];
            int min = (pics < newPics) ? pics : newPics;
            for (int i = 0; i < min; i++) {
                info[i] = tmp[i];//Copiam datele din vectorul temporar despre numarul nou de picaturi
            }
            pics = newPics;
        }
    }

    public int getInfo(int id) { //informatii despre directia de miscare a motanului dupa picatura cu indexul id
        if (id >= 0 && id <= pics)   //controlăm corectitudinea parametrilor
            return info[id];
        return -1;
    }

    public void setInfo(int id, int newInfo) {
        if (id > 0 && id <= pics && newInfo >= 1 && newInfo <= 4)
            info[id] = newInfo;  //dacă sunt corecte, introducem info în poziția cu indicile id

    }

    //////////////////////////////////////metoda afisării la ecran a tuturor cîmpurilor clasei /////////////////////////////////////////
    public void afisare() {
        System.out.println("----------------------");
        System.out.println("Numele Motanului este " + name);
        System.out.println("Greutatea motanului " + mass);
        System.out.println("Pufosenia motanului " + fur);
        System.out.println("Cantitatea de picaturi: " + pics);
        System.out.println("Directia picaturilor : ");
        for (int i = 0; i < pics; i++) {
            System.out.print("  " + info[i]);  //afișăm toata informatia intr-o linie, separîndu-le prin spațiu
        }
        System.out.println(" ");
        System.out.println("----------------------");
        System.out.println("**********************");
    }

    //Atribuirea valorilor random pentru campurile obiectului motan
// metoda care completeaza toate campurile obiectului cu valori aleatoare
    public void randomizeMotan() {
        String names[] = {"Eliot", "Garfield", "Ferdinand", "Tom", "Pluto", "Max", "Pisi"};
        int id = (new Random().nextInt(names.length));
        name = names[id];
        float f = (new Random().nextFloat() * 15);
        mass = f;
        int b = (new Random().nextInt(10));
        byte bi = (byte) b;
        fur = bi;
        int p = (new Random().nextInt(30));
        setPics(p);
        for (int i = 0; i < p; i++) {
            int val = 1 + (new Random().nextInt(4));
            info[i] = val;
        }

    }
//citeste si returneaza un string de la tastatura

    public static String inString() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));   //Citește text dintr-un flux de introducere a caracterelor, //tamponând caractere astfel încât să asigure citirea eficientă a caracterelor, matricelor și liniilor.
        String str = "";
        try {   // testare erori
            str = reader.readLine();
        } catch (IOException e) {

        }
        return str;

    }

    public void inputMotanData() {
        println("Introdu numele motanului ");
        name = inString();
        float masa = -1;
        do {
            println("Introdu masa motanului  val acceptate 0- 15 ");
            masa = Float.parseFloat(inString());
            setMass(masa);

        }
        while
        (masa <= 0 || masa > 15);
        byte blana = -1;
        do {
            System.out.println("Introdu pufosenia motanului  val acceptate 0- 10 ");
            blana = Byte.parseByte(inString());
            setFur(blana);
        }
        while (blana < 0 || blana > 10);
        int picaturi = 0;
        do {
            System.out.println("Introdu numarul picaturilor de valeriana consumate de motan ");
            picaturi = Integer.parseInt(inString());
            setPics(picaturi);
        }
        while (picaturi < 0);

        System.out.println("Introdu directia in care se taraie motanul dupa fiecare picatura ");
        for (int i = 0; i < getPics(); i++) {
            int info = 0;
            do {
                System.out.print("Directia picaturii " + (i + 1) + ": ");
                info = Integer.parseInt(inString());
                setInfo(i, info);
            }
            while (info < 1 || info > 4);

        }
    }

    public void traiectorie() { ///Traiectoria cum se misca motanul
        System.out.println("Traiectoria lui " + name + ": ");
        for (int i = 0; i < pics; i++) {
            if (i != 0 && i % 10 == 0) print("zzzzz-zzzzz-zzzzz");
            switch (info[i]) {
                case 1:
                    System.out.print(" ⇧ ");
                    break;
                case 2:
                    System.out.print(" ⇩ ");
                    break;
                case 3:
                    System.out.print(" ⇦ ");
                    break;
                case 4:
                    System.out.print(" ⇨ ");
                    break;
                default:
                    System.out.print(" . ");
            }
        }
        System.out.println(" ");
    }

    public void println(String S) {
        System.out.println(S);
    }

    public void print(String S) {
        System.out.print(S);
    }


//functia cea mai principala main///////

    public static void main(String[] args) {

        Motan a = new Motan();
        System.out.println("Motan creat cu constructor implicit :");
        a.afisare();
        a.traiectorie();

        Motan b = new Motan("Jack", 3);
        System.out.println("Motan creat cu constuctor cu paramentri ");
        b.afisare();
        b.traiectorie();

        Motan klon = new Motan(b);
        System.out.println("Motan creat cu constructor de copiere ");
        klon.afisare();
        klon.traiectorie();
        System.out.println("Nr de obiecte create " + Motan.nr);

        System.out.println("Testam setterii : ");
        b.setName("Testam, fostul Jack");
        b.setMass(12);
        b.setFur((byte) 3);
        b.setPics(10);
        b.setInfo(3, 4);
        b.afisare();
        //testam getterii
        int picaturi = b.getPics();
        float masa = b.getMass();
        String Test = b.getName();
        byte furr = b.getFur();

        int vector = b.getInfo(1);
        System.out.println("Afisam datele cu getteri");
        System.out.println(Test);
        System.out.println(masa);
        System.out.println(furr);
        System.out.println(picaturi);
        System.out.println(vector);

        System.out.println("Testam randomizerul :");
        Motan alb = new Motan();
        alb.afisare();
        alb.randomizeMotan();
        alb.afisare();
        alb.traiectorie();

        System.out.println("Introducem datele de la tastatura");
        alb.inputMotanData();
        alb.afisare();

        System.out.println("Arrayul de obiecte : ");
        Motan array[];
        array = new Motan[10];
        array[0] = new Motan("Dan", 5);
        array[1] = new Motan();
        array[2] = new Motan(array[0]);
        array[3] = new Motan();
        array[3].inputMotanData();

        int valTotal = 0;
        int valMax;
        byte valMin;
        valMin = array[0].getFur();
        valMax = array[0].getPics();
        for (int i = 4; i < 10; i++) {
            array[i] = new Motan();
            array[i].randomizeMotan();
        }
//Afisarea tutoror motanilor din vectorul creat
        for (int i = 0; i < 10; i++) {
            System.out.println("Motanul cu indexul " + i);
            array[i].afisare();
            array[i].traiectorie();
            valTotal = valTotal + array[i].getPics();  //cantitatea totala  de de picaturi
            if (valMax < array[i].getPics()) {
                valMax = array[i].getPics();
            }
            if (valMin < array[i].getFur()) {
                valMin = array[i].getFur();
            }
        }
        for (int i = 0; i < 10; i++) {
            if (array[i].getPics() == valMax) {
                System.out.println("Motanul cu cantatitea maxima de picaturi consumate este " + array[i].getName() + " si a consumat " + valMax + " si are indexul " + i);
            }
            if (array[i].getFur() == valMin) {
                System.out.println("Motanul cel mai pufos este " + array[i].getName() + " cu blana de " + valMin + " unitati si are indexul " + i);
            }
        }
        System.out.println(" Valoarea maxima de valeriana e " + valMax);
        System.out.println("Val totala de valeriana consumata este " + valTotal);
    }
}
