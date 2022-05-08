package supermarket.client;
import supermarket.domain.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Home extends JFrame implements ActionListener{

    public JButton btnP,btnR,Sub,btnD,btnH,btnV,rem, bprofile;
    public JRadioButton Rb1,Rb2,Rb3,Rb4,ans,Rb10;
    public JRadioButton Rb5,Rb6,Rb7,Rb8,Rb9;
    public JRadioButton Rb11,Rb12,Rb13,Rb14,Rb15;
    public JRadioButton Rb20,Rb16,Rb17,Rb18,Rb19;
    public JRadioButton Rb25,Rb21,Rb22,Rb23,Rb24;
    public JLabel pl1,pl2,pl3,pl4,pl5;
    public ButtonGroup BG1,BG2,BG3,BG4,BG5;
    public JLabel l1,l2,l3,l4,l5;
    public Container con;
    public String[] Sary;

    public Home(User user) {

        Sary= new String[5];
        for(int x=0;x<Sary.length;x++)
            Sary[x]=" ";

        this.setVisible(true);
        this.setSize(600,435);
        con= getContentPane();
        con.setLayout(null);

        final Box b1= Box.createVerticalBox();
        final Box b2= Box.createVerticalBox();
        final Box b3= Box.createVerticalBox();
        final Box b4= Box.createVerticalBox();
        final Box b5= Box.createVerticalBox();
        final Box first= Box.createVerticalBox();
        final Box buy= Box.createVerticalBox();
        final Box choz= Box.createVerticalBox();
        con.setBackground(Color.white);


        l1= new JLabel("");
        l2= new JLabel("");
        l3= new JLabel("");
        l4= new JLabel("");
        l5= new JLabel("");




        first.setVisible(true);
        first.setBounds(125, 0, 275, 450);
        first.setBorder(BorderFactory.createTitledBorder(" "));
        con.add(first);
        buy.setVisible(true);
        buy.setBounds(400, 0, 200, 450);
        buy.setBorder(BorderFactory.createTitledBorder("Selected items"));
        con.add(buy);

        BG1=new ButtonGroup();
        BG2= new ButtonGroup();
        BG3= new ButtonGroup();
        BG4= new ButtonGroup();
        BG5= new ButtonGroup();



//Processors



        Rb1= new JRadioButton("Apple");
        Rb2= new JRadioButton("Pears");
        Rb3= new JRadioButton("Grapes");
        Rb4= new JRadioButton("Watermelon");
        Rb5= new JRadioButton("Banana");

        pl1=new JLabel("Price - 2€/kg ");
        pl2=new JLabel("Price - 1€/kg ");
        pl3=new JLabel("Price - 3€/kg ");
        pl4=new JLabel("Price - 1€/kg ");
        pl5=new JLabel("Price - 4€/kg ");

        ImageIcon p1 = new ImageIcon("images/user.png");
        JLabel Lp1 = new JLabel(" ", p1, JLabel.CENTER);
        JLabel Lp2 = new JLabel(p1, JLabel.CENTER);

        BG1.add(Rb1);
        BG1.add(Rb2);
        BG1.add(Rb3);
        BG1.add(Rb4);
        BG1.add(Rb5);




        b1.add( Box.createRigidArea(new Dimension(0,10)));
        b1.add(Rb1);
        b1.add(pl1);
        b1.add( Box.createRigidArea(new Dimension(0,8)));
        b1.add(Rb2);
        b1.add(pl2);
        b1.add( Box.createRigidArea(new Dimension(0,8)));
        b1.add(Rb3);
        b1.add(pl3);
        b1.add( Box.createRigidArea(new Dimension(0,8)));
        b1.add(Rb4);
        b1.add(pl4);
        b1.add( Box.createRigidArea(new Dimension(0,8)));
        b1.add(Rb5);
        b1.add(pl5);
        b1.add(Lp1);


        Rb1.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[0]= Rb1.getText();
                l2.setText(Sary[0]);
            }}});
        Rb2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[0]= Rb2.getText();
                l2.setText(Sary[0]);
            }}});
        Rb3.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[0]= Rb3.getText();
                l2.setText(Sary[0]);
            }}});
        Rb4.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[0]= Rb4.getText();
                l2.setText(Sary[0]);
            }}});
        Rb5.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[0]= Rb5.getText();
                l2.setText(Sary[0]);
            }}});

        b1.setVisible(false);
        b1.setBounds(125, 0, 275, 450);
        b1.setBorder(BorderFactory.createTitledBorder(" "));
        btnP=new JButton(" Fruit ");
        btnP.setMaximumSize(new Dimension(120, 25));

        bprofile =new JButton(" PROFILE ");
        bprofile.setMaximumSize(new Dimension(120, 25));


        con.add(b1);

        btnP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b1.setVisible(true);
                b2.setVisible(false);
                b3.setVisible(false);
                b4.setVisible(false);
                b5.setVisible(false);
                first.setVisible(false);
            }});
//Ram

        Rb10= new JRadioButton("Chicken pieces");
        Rb9= new JRadioButton("Steak premium");
        Rb6= new JRadioButton("Pork Ribs");
        Rb7= new JRadioButton("Mixed meat");
        Rb8= new JRadioButton("Chicken wings");

        pl1=new JLabel("Price - 9€/kg");
        pl2=new JLabel("Price - 24€/kg");
        pl3=new JLabel("Price - 12€/kg");
        pl4=new JLabel("Price - 21€/kg");
        pl5=new JLabel("Price - 22€/kg");

        ImageIcon r1 = new ImageIcon("images\\cc.png");
        JLabel R1 = new JLabel(" ", r1, JLabel.CENTER);

        BG2.add(Rb10);
        BG2.add(Rb9);
        BG2.add(Rb6);
        BG2.add(Rb7);
        BG2.add(Rb8);

        b2.add( Box.createRigidArea(new Dimension(0,20)));
        b2.add(Rb10);
        b2.add(pl1);
        b2.add( Box.createRigidArea(new Dimension(0,8)));
        b2.add(Rb9);
        b2.add(pl2);
        b2.add( Box.createRigidArea(new Dimension(0,8)));
        b2.add(Rb6);
        b2.add(pl3);
        b2.add( Box.createRigidArea(new Dimension(0,8)));
        b2.add(Rb7);
        b2.add(pl4);
        b2.add( Box.createRigidArea(new Dimension(0,8)));
        b2.add(Rb8);
        b2.add(pl5);
        b2.add( Box.createRigidArea(new Dimension(0,10)));
        b2.add(R1);

        Rb9.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[1]= Rb9.getText();
                l3.setText(Sary[1]);
            }}});
        Rb10.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[1]= Rb10.getText();
                l3.setText(Sary[1]);
            }}});
        Rb6.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[1]= Rb6.getText();
                l3.setText(Sary[1]);
            }}});
        Rb7.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[1]= Rb7.getText();
                l3.setText(Sary[1]);
            }}});
        Rb8.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[1]= Rb8.getText();
                l3.setText(Sary[1]);
            }}});


        b2.setVisible(false);
        b2.setBounds(125, 0, 275, 450);
        b2.setBorder(BorderFactory.createTitledBorder(" "));
        btnR=new JButton("Meat");
        btnR.setMaximumSize(new Dimension(120, 25));
        con.add(b2);



        btnR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b2.setVisible(true);
                b1.setVisible(false);
                b3.setVisible(false);
                b4.setVisible(false);
                b5.setVisible(false);
                first.setVisible(false);

            }});
//Hard

        Rb11= new JRadioButton("Chocolate Cookies ");
        Rb12= new JRadioButton("Bread");
        Rb13= new JRadioButton("Butter");
        Rb14= new JRadioButton("Apricot jam");
        Rb15= new JRadioButton("Muffins");

        pl1=new JLabel("Price - 2€");
        pl2=new JLabel("Price - 5€");
        pl3=new JLabel("Price - 2€");
        pl4=new JLabel("Price - 3€");
        pl5=new JLabel("Price - 4€");

        ImageIcon h1 = new ImageIcon("images\\Lh1.jpg");
        JLabel hd1 = new JLabel(" ", h1, JLabel.CENTER);

        BG3.add(Rb15);
        BG3.add(Rb11);
        BG3.add(Rb12);
        BG3.add(Rb13);
        BG3.add(Rb14);

        b3.add( Box.createRigidArea(new Dimension(0,20)));
        b3.add(Rb15);
        b3.add(pl1);
        b3.add( Box.createRigidArea(new Dimension(0,8)));
        b3.add(Rb11);
        b3.add(pl2);
        b3.add( Box.createRigidArea(new Dimension(0,8)));
        b3.add(Rb12);
        b3.add(pl3);
        b3.add( Box.createRigidArea(new Dimension(0,8)));
        b3.add(Rb13);
        b3.add(pl4);
        b3.add( Box.createRigidArea(new Dimension(0,8)));
        b3.add(Rb14);
        b3.add(pl5);
        // b3.add( Box.createRigidArea(new Dimension(0,10)));
        b3.add(hd1);

        Rb15.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[2]= Rb15.getText();
                l4.setText(Sary[2]);
            }}});
        Rb11.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[2]= Rb11.getText();
                l4.setText(Sary[2]);
            }}});
        Rb12.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[2]= Rb12.getText();
                l4.setText(Sary[2]);
            }}});
        Rb13.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[2]= Rb13.getText();
                l4.setText(Sary[2]);
            }}});
        Rb14.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[2]= Rb14.getText();
                l4.setText(Sary[2]);
            }}});

        b3.setVisible(false);
        b3.setBounds(125, 0, 275, 450);
        b3.setBorder(BorderFactory.createTitledBorder(" "));
        btnH=new JButton("Breakfast");
        btnH.setMaximumSize(new Dimension(120, 25));
        con.add(b3);



        btnH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b3.setVisible(true);
                b1.setVisible(false);
                b2.setVisible(false);
                b4.setVisible(false);
                b5.setVisible(false);
                first.setVisible(false);

            }});
//Disply

        Rb20= new JRadioButton("Ketchup");
        Rb19= new JRadioButton("BBQ sauce");
        Rb16= new JRadioButton("Garlic sauce ");
        Rb17= new JRadioButton("Mustard");
        Rb18= new JRadioButton("Mayonnese");


        pl1=new JLabel("Price - 1€ ");
        pl2=new JLabel("Price - 2€ ");
        pl3=new JLabel("Price - 1€");
        pl4=new JLabel("Price - 3€ ");
        pl5=new JLabel("Price - 2€ ");


        Rb19.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[3]= Rb19.getText();
                l5.setText(Sary[3]);
            }}});
        Rb20.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[3]= Rb20.getText();
                l5.setText(Sary[3]);
            }}});
        Rb16.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[3]= Rb16.getText();
                l5.setText(Sary[3]);
            }}});
        Rb17.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[3]= Rb17.getText();
                l5.setText(Sary[3]);
            }}});
        Rb18.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[3]= Rb18.getText();
                l5.setText(Sary[3]);
            }}});

        ImageIcon s1 = new ImageIcon("images\\LS1.jpg");
        JLabel ls1 = new JLabel(" ", s1, JLabel.CENTER);

        BG4.add(Rb20);
        BG4.add(Rb19);
        BG4.add(Rb16);
        BG4.add(Rb17);
        BG4.add(Rb18);

        b4.add( Box.createRigidArea(new Dimension(0,50)));
        b4.add(Rb20);
        b4.add(pl1);
        b4.add( Box.createRigidArea(new Dimension(0,8)));
        b4.add(Rb19);
        b4.add(pl2);
        b4.add( Box.createRigidArea(new Dimension(0,8)));
        b4.add(Rb16);
        b4.add(pl3);
        b4.add( Box.createRigidArea(new Dimension(0,8)));
        b4.add(Rb17);
        b4.add(pl4);
        b4.add( Box.createRigidArea(new Dimension(0,8)));
        b4.add(Rb18);
        b4.add(pl5);
        b4.add(ls1);

        b4.setVisible(false);
        b4.setBounds(125, 0, 275, 450);
        b4.setBorder(BorderFactory.createTitledBorder(" "));
        btnV=new JButton("Sauces");
        btnV.setMaximumSize(new Dimension(120, 25));
        con.add(b4);



        btnV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b4.setVisible(true);
                b1.setVisible(false);
                b3.setVisible(false);
                b2.setVisible(false);
                b5.setVisible(false);
                first.setVisible(false);

            }});


//typ
        pl1=new JLabel("Price - 500€ ");
        pl2=new JLabel("Price - 1200€");
        pl3=new JLabel("Price - 1000€");
        pl4=new JLabel("Price - 800€");
        pl5=new JLabel("Price - 1300€");

        final Box hb1= Box.createHorizontalBox();
        final Box hb2= Box.createHorizontalBox();
        final Box hb3= Box.createHorizontalBox();
        final Box hb4= Box.createHorizontalBox();

        final Box hb11= Box.createHorizontalBox();
        final Box hb12= Box.createHorizontalBox();
        ;

        ImageIcon i1 = new ImageIcon("src/main/java/supermarket/client/images/tresBarras.png");
        JLabel LM1 = new JLabel(" ", i1, JLabel.CENTER);

        ImageIcon i2 = new ImageIcon("images\\LM2.jpg");
        JLabel LM2 = new JLabel(" ", i2, JLabel.CENTER);

        ImageIcon i3 = new ImageIcon("images\\LM3.jpg");
        JLabel LM3 = new JLabel(" ", i3, JLabel.CENTER);

        ImageIcon i4 = new ImageIcon("images\\LM4.jpg");
        JLabel LM4 = new JLabel(" ", i4, JLabel.CENTER);

        ImageIcon i5 = new ImageIcon("images\\LM5.jpg");
        JLabel LM5 = new JLabel(" ", i5, JLabel.CENTER);


        Rb21= new JRadioButton("Diet fanta");
        Rb22= new JRadioButton("Coke light");
        Rb23= new JRadioButton("Orange juice");
        Rb24= new JRadioButton("Water");
        Rb25= new JRadioButton("Cold beer");

        BG5.add(Rb21);
        BG5.add(Rb22);
        BG5.add(Rb23);
        BG5.add(Rb24);
        BG5.add(Rb25);

        // b5.add( Box.createRigidArea(new Dimension(0,50)));
        hb1.add(LM1);
        hb2.add(Rb21);
        hb11.add(pl1);
        hb11.add( Box.createRigidArea(new Dimension(10,0)));
        hb11.add(pl2);
        hb1.add(LM2);
        hb2.add(Rb22);

        b5.add(hb1);
        b5.add(hb2);
        b5.add(hb11);
        //b5.add( Box.createRigidArea(new Dimension(0,5)));

        hb3.add(LM3);
        hb4.add(Rb23);
        hb3.add(LM4);
        hb4.add(Rb24);
        hb12.add(pl3);
        hb12.add( Box.createRigidArea(new Dimension(10,0)));
        hb12.add(pl4);
        b5.add(hb3);
        b5.add(hb4);
        b5.add(hb12);

        b5.add(LM5);
        b5.add(Rb25);
        b5.add(pl5);


        Rb21.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[4]= Rb21.getText();
                l1.setText(Sary[4]);
            }}});
        Rb22.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[4]= Rb22.getText();
                l1.setText(Sary[4]);
            }}});
        Rb23.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[4]= Rb23.getText();
                l1.setText(Sary[4]);
            }}});
        Rb24.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[4]= Rb24.getText();
                l1.setText(Sary[4]);
            }}});
        Rb25.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {{
                Sary[4]= Rb25.getText();
                l1.setText(Sary[4]);
            }}});

        b5.setVisible(false);
        b5.setBounds(125, 0, 275, 450);
        b5.setBorder(BorderFactory.createTitledBorder(" "));
        btnD=new JButton("Drinks");
        btnD.setMaximumSize(new Dimension(120, 25));
        con.add(b5);



        btnD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b5.setVisible(true);
                b1.setVisible(false);
                b3.setVisible(false);
                b4.setVisible(false);
                b2.setVisible(false);
                first.setVisible(false);

            }});
//Submit
        Sub = new JButton(" SUBMIT ");
        Sub.setMaximumSize(new Dimension(120, 25));
        Sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                for(int x=0;x<Sary.length;x++)
                    System.out.println(Sary[x]);


            }});

        buy.add(l1);
        buy.add(l2);
        buy.add(l3);
        buy.add(l4);
        buy.add(l5);
        //remove
        rem = new JButton(" Remove ");
        rem.setMaximumSize(new Dimension(120, 25));
        rem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int x=0;x<Sary.length;x++)
                    Sary[x]=" ";

                l1.setText(" ");
                l2.setText(" ");
                l3.setText(" ");
                l4.setText(" ");
                l5.setText(" ");

            }});
        //listener de profile
        bprofile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaPerfil perfil= new VentanaPerfil(null,user);

            }});



        choz.add( Box.createRigidArea(new Dimension(0,50)));
        choz.add(btnD);
        choz.add( Box.createRigidArea(new Dimension(0,5)));
        choz.add(btnP);
        choz.add( Box.createRigidArea(new Dimension(0,5)));
        choz.add(btnR);
        choz.add( Box.createRigidArea(new Dimension(0,5)));
        choz.add(btnH);
        choz.add( Box.createRigidArea(new Dimension(0,5)));
        choz.add(btnV);
        choz.add( Box.createRigidArea(new Dimension(0,5)));
        choz.add(bprofile);

        buy.add( Box.createRigidArea(new Dimension(0,50)));
        ImageIcon image = new ImageIcon("images\\1.jpg");
        JLabel label1 = new JLabel("Cart ", image, JLabel.CENTER);
        buy.add(label1);
        buy.add(Sub);
        buy.add(rem);
        choz.setBorder(BorderFactory.createTitledBorder("Choose "));
        choz.setBounds(0, 0, 125, 450);
        con.add(choz);


    }


    public void back(String[] ar){
        for(int x=0;x<5;x++){
            Sary[x]= ar[x];
        }

        l2.setText(Sary[0]);
        l3.setText(Sary[1]);
        l4.setText(Sary[2]);
        l5.setText(Sary[3]);
        l1.setText(Sary[4]);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}

