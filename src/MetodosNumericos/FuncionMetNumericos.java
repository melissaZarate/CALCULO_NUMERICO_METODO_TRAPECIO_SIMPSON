
package MetodosNumericos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import static javafx.scene.input.KeyCode.L;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

import org.nfunk.jep.JEP;


             
public class FuncionMetNumericos extends javax.swing.JFrame {
          DecimalFormat dec= new DecimalFormat("#.00000");
          //declaramos como variables locales
          public double  valora=0;
          public double valorb=0;
          public int valorn=0;
          public String funcion="";
          public double h;
          public double valh=0;
          //declaramos una cariables para utilizar la libreria JEP
          JEP jep;
          //delaramos modelos para utilizar en las listas
          DefaultListModel modelo=new DefaultListModel();
          DefaultListModel modelo2=new DefaultListModel();
          DefaultListModel modelo3=new DefaultListModel();
          DefaultListModel modelo4=new DefaultListModel();
          DefaultListModel modelo5=new DefaultListModel();
          DefaultListModel modelo6=new DefaultListModel();
          DefaultListModel modelo7=new DefaultListModel();
          
        
   
          
  
    public FuncionMetNumericos() {
        
        initComponents();
        
      //  valora=0;
       // valorb=0;
      //  funcion="";
         
        this.setLocationRelativeTo(null); 
     }
    
    public void calculode_trapecio()
    {
         jep= new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.setImplicitMul(true);
         double xs;
        double resultfuncion = 0;
        double temp;
        double integral;
        double suminttot=0;
      
          //obtenemos h
          h=(valorb-valora)/valorn;
          txth.setText(String.valueOf(dec.format(h)));
       
        //obtenemos vector para las x
        double x[]= new double[valorn+1]; //6
       
         x[0]=valora;
        xs=valora;
        
        for(int i=1;i<valorn;i++)
        {
            xs=xs+h;
            x[i]=xs; 
        }
        x[valorn]=valorb;
        
        for( int i=0;i<valorn+1;i++)
        {
            if(i==0)
            {
                modelo.addElement("a = "+dec.format(x[i]));
                jlistx.setModel(modelo);
                
            }
            else{
             modelo.addElement("x"+(i-1)+"= "+dec.format(x[i]));
                jlistx.setModel(modelo);
               
            }
        }
        //creamos nuevo vector para fx
        double fx[]=new double[valorn+1];
        for (int i=0;i<valorn+1;i++)
        {
            jep.addVariable("x",x[i]);
            jep.parseExpression(funcion);
            fx[i]=jep.getValue();
            
            modelo2.addElement("f(x)"+i+"= "+dec.format(fx[i]));
                jlistfx.setModel(modelo2);
        }
       //calculamos  las integrales su intgral total
        temp= fx[0];
        for(int i=1;i<=valorn;i++)
        {
            integral=(h/2)*(temp+fx[i]);
            temp=fx[i];
            suminttot=suminttot+integral;
            
             modelo3.addElement("integral "+i+"= "+dec.format(integral));
                jlistintegrales.setModel(modelo3);   
        }
        txtsumatoria.setText(String.valueOf(suminttot));
     
    }
    
    public void calculode_simpson()
    {
        //funciones que realizaraJEP al introducir una cadena 
        jep= new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.setImplicitMul(true);
        double xs;
        double resultfuncion = 0;
        double temp1;
        double temp2;
        double temp3;
        double integral;
        double suminttot=0;
        int iterador=valorn+1;
        //obtenemos h
          int inter=0;
          if((valorn%2)!=0)
          {
              JOptionPane.showMessageDialog(null,"Para el Metodo Simpson 1/3 recuerde que el \n numero de intervalo n, dee ser multiplo de 2");
          }
          else
          {
          h=(valorb-valora)/valorn;
          txth.setText(String.valueOf(dec.format(h)));
      //obtenemos vector para las x
        double x[]= new double[valorn+1]; //6
         x[0]=valora;
        xs=valora;
        
        for(int i=1;i<valorn;i++)
        {
            xs=xs+h;
            x[i]=xs; 
        }
        x[valorn]=valorb;
        
       for( int i=0;i<iterador;i++)
        {
            if(i==0)
            {
                modelo.addElement("a = "+dec.format(x[i]));
                jlistx.setModel(modelo);
                
            }
            else{
             modelo.addElement("x"+(i-1)+"= "+dec.format(x[i]));
                jlistx.setModel(modelo);
               
            }
        }
        //creamos nuevo vector para fx
        double fx[]=new double[valorn+1];
        for (int i=0;i<fx.length;i++)
        {
            jep.addVariable("x",x[i]);
            jep.parseExpression(funcion);
            fx[i]=jep.getValue();
            
            modelo2.addElement("f(x)"+i+"= "+dec.format(fx[i]));
                jlistfx.setModel(modelo2);
        }
       //calculamos  las integrales de simpson y su intgral total
    
        double it[]=new double[valorn+1];
        for(int i=0;i<valorn;i=i+2)
        {
            it[i]=(h/3)*(fx[i]+(4*fx[i+1])+fx[i+2]);
            suminttot=suminttot+it[i];
          
        }
         
        for(int i=0;i< valorn;i=i+2)
        {
            modelo3.addElement("integral"+i+" = "+dec.format(it[i]));
            jlistintegrales.setModel(modelo3);
            txtsumatoria.setText(String.valueOf(dec.format(suminttot)));
        }
   
       }
        
    }
    public void datos_trapecio()
    {   
        // JOptionPane.showMessageDialog(null,"IMPORTANTE: cuando termine de ingresar datos para X \n seleccione los intervalos a y b ");
        // funcion paraleer los datos ingresados por el usuario a la lista
      
        double integral;
        double dato;
        double dato2;
        String cadena3;
        String cadena4;
        String cadena1="";//
        double numero; //
        double resu=0; //
        ListModel listt=jlistx.getModel();
        for(int i=0;i<listt.getSize();i++)
        {
            cadena1=listt.getElementAt(i).toString();
            numero= Double.parseDouble(cadena1);
            if(i==0)
            {
                resu= numero;
            }
            if(i==(listt.getSize()-1))
            {
               resu= numero-resu; 
            }
            
        }
        double suminttot=0;
        h=(resu)/valorn;
        txth.setText(String.valueOf(dec.format(h)));
        
            //calculamos las integrales
        ListModel list=jlistfx.getModel();
        for(int i=0;i<list.getSize();i++)
        {
            cadena3=list.getElementAt(i).toString();
            dato=Double.parseDouble(cadena3);
            cadena4=list.getElementAt(i+1).toString();
            dato2=Double.parseDouble(cadena4);

            integral=(h/2)*(dato + dato2);
            
            suminttot=suminttot+integral;
            
             modelo6.addElement("integral "+i+"= "+dec.format(integral));
                jlistintegrales.setModel(modelo6);   
        }
        txtsumatoria.setText(String.valueOf(suminttot));
        //calculamos grafica de trapecio
    }
    public void datos_simpson()
    {
       //  JOptionPane.showMessageDialog(null,"IMPORTANTE: cuando termine de ingresar datos para X \n seleccione los intervalos a y b ");
        // funcion paraleer los datos ingresados por el usuario a la lista
        ListModel list=jlistfx.getModel();
        double integral;
        double dato;
        double dato2;
        double dato3;
        String cadena;
        String cadena2;
        String cadena3;
        String cadena1;
        double numero;
       
        double resu=0;
        int num;
        num=list.getSize()-1;
        double suminttot=0;
        //para este metodo el numero de intervalos debe ser divisible entre dos
        if(((num)%2)!=0)
          {
              JOptionPane.showMessageDialog(null,"Para el Metodo Simpson 1/3 recuerde que el \n numero de intervalo n, dee ser multiplo de 2; \n nno se puede aplicar este metodo");
          }
          else
          {
        
         for(int i=0;i<jlistx.getModel().getSize();i++)
        {
            cadena1=jlistx.getModel().getElementAt(i).toString();
            numero= Double.parseDouble(cadena1);
            if(i==0)
            {
                resu= numero;
            }
            if(i==(jlistx.getModel().getSize()-1))
            {
               resu= numero-resu; 
            }
            
        }
      
        h=(resu)/valorn;
        txth.setText(String.valueOf(dec.format(h)));
        for(int i=0;i<list.getSize();i=i+2)
        {
            cadena=list.getElementAt(i).toString();
            dato=Double.parseDouble(cadena);
            cadena2=list.getElementAt(i+1).toString();
            dato2=Double.parseDouble(cadena2);
            cadena3=list.getElementAt(i+2).toString();
            dato3=Double.parseDouble(cadena2);

            integral=(h/3)*(dato+(4*dato2)+dato3);
            
            suminttot=suminttot+integral;
            
             modelo7.addElement("integral "+i+"= "+dec.format(integral));
                jlistintegrales.setModel(modelo7);  
                txtsumatoria.setText(String.valueOf(suminttot));
        }
         
    }
    }
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jlabelmetodo = new javax.swing.JLabel();
        btntrapecio = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtvalora = new javax.swing.JTextField();
        txtvalorb = new javax.swing.JTextField();
        txtfuncion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlistx = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlistfx = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlistintegrales = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlbresultado = new javax.swing.JLabel();
        txtsumatoria = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txth = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        txtx = new javax.swing.JTextField();
        txtfx = new javax.swing.JTextField();
        btnañadirfx = new javax.swing.JButton();
        jchingresar = new javax.swing.JCheckBox();
        btnañadirx = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 109, 160));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, -1));

        jlabelmetodo.setBackground(new java.awt.Color(204, 204, 204));
        jlabelmetodo.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jlabelmetodo.setForeground(new java.awt.Color(153, 0, 51));
        jlabelmetodo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlabelmetodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ICONO.png"))); // NOI18N
        jlabelmetodo.setText(" METODOS NUMERICOS ");
        getContentPane().add(jlabelmetodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-180, 10, 630, 60));

        btntrapecio.setBackground(new java.awt.Color(0, 108, 158));
        btntrapecio.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btntrapecio.setForeground(new java.awt.Color(255, 255, 255));
        btntrapecio.setText("TRAPECIO");
        btntrapecio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btntrapecio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btntrapecio.setIconTextGap(7);
        btntrapecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntrapecioActionPerformed(evt);
            }
        });
        getContentPane().add(btntrapecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 160, 30));

        jButton3.setBackground(new java.awt.Color(0, 108, 158));
        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("SIMPSON 1/3  ");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 160, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sumbintegra.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 30, 90));

        txtvalora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtvalora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtvalora, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 90, 30));

        txtvalorb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtvalorb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtvalorb, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 100, 30));

        txtfuncion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtfuncion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtfuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 160, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dx.PNG"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 50, 40));

        jlistx.setSelectionBackground(new java.awt.Color(255, 255, 204));
        jScrollPane1.setViewportView(jlistx);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 140, 140));

        jScrollPane2.setViewportView(jlistfx);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 140, 140));

        jScrollPane3.setViewportView(jlistintegrales);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 130, 140));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        jLabel3.setText("                 x");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 140, 20));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        jLabel4.setText("               f(x)");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 140, 20));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        jLabel5.setText("          Integral");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 130, 20));

        jlbresultado.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        jlbresultado.setForeground(new java.awt.Color(153, 0, 0));
        jlbresultado.setText("sumaroria de la integral:");
        getContentPane().add(jlbresultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 220, 30));

        txtsumatoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtsumatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsumatoriaActionPerformed(evt);
            }
        });
        getContentPane().add(txtsumatoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 290, 30));

        jButton2.setBackground(new java.awt.Color(0, 109, 160));
        jButton2.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LIMPIAR.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 600, 90, 70));

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel6.setText("n:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        txtn.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        txtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 60, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel8.setText("n:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel9.setText("h=");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        txth.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        txth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txth, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 80, 40));

        jButton4.setBackground(new java.awt.Color(0, 108, 158));
        jButton4.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Añadir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 530, -1, -1));
        getContentPane().add(txtx, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 120, -1));
        getContentPane().add(txtfx, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 500, 120, -1));

        btnañadirfx.setBackground(new java.awt.Color(0, 108, 158));
        btnañadirfx.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnañadirfx.setForeground(new java.awt.Color(255, 255, 255));
        btnañadirfx.setText("añadir");
        btnañadirfx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnañadirfxActionPerformed(evt);
            }
        });
        getContentPane().add(btnañadirfx, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 530, -1, -1));

        jchingresar.setText("ingresar datos");
        jchingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchingresarActionPerformed(evt);
            }
        });
        getContentPane().add(jchingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        btnañadirx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/newFOND.png"))); // NOI18N
        btnañadirx.setIconTextGap(1);
        getContentPane().add(btnañadirx, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btntrapecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntrapecioActionPerformed
        //llamamos a los valores
          /*valora= Double.parseDouble(txtvalora.getText());
          valorb= Double.parseDouble(txtvalorb.getText());
          valorn=Integer.parseInt(txtn.getText());
          funcion=txtfuncion.getText();*/
         String cadena1="";//
        double numero; //
        double resu=0; //
       
          if( jchingresar.isSelected()==true)
          {
             valorn=Integer.parseInt(txtn.getText());
              JOptionPane.showMessageDialog(null," INGRESE DAOS PARA TRAPECIO"); 
            
              datos_trapecio();
          }
          else
          {
          valora= Double.parseDouble(txtvalora.getText());
          valorb= Double.parseDouble(txtvalorb.getText());
          valorn=Integer.parseInt(txtn.getText());
          funcion=txtfuncion.getText();
          calculode_trapecio();
          }
          

        
    }//GEN-LAST:event_btntrapecioActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      /* valora= Double.parseDouble(txtvalora.getText());
          valorb= Double.parseDouble(txtvalorb.getText());
          valorn=Integer.parseInt(txtn.getText());
          funcion=txtfuncion.getText();*/
          /*valora=0;
              valorb=0;
              funcion="";*/
        
          if( jchingresar.isSelected()==true)
          {
              valorn=Integer.parseInt(txtn.getText());
              JOptionPane.showMessageDialog(null,"INGRESE DATOS PARA SIMSON  ");  
              
                
              datos_simpson();
          }
          else
          {
              valora= Double.parseDouble(txtvalora.getText());
          valorb= Double.parseDouble(txtvalorb.getText());
          valorn=Integer.parseInt(txtn.getText());
          funcion=txtfuncion.getText();
          calculode_simpson();
          }
          
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtsumatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsumatoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsumatoriaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //boton para vaciar 
        txtvalora.setText("");
        txtvalorb.setText("");
        txtn.setText("");
        txtfuncion.setText("");
        txth.setText("");
        txtsumatoria.setText("");
        modelo.clear();
        modelo2.clear();
        modelo3.clear();
        modelo4.clear();
        modelo5.clear();
        modelo6.clear();
        modelo7.clear();
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       ArrayList vector=new ArrayList();
       String dato= txtx.getText();
       vector.add(dato);
       modelo4.addElement(vector);
        jlistx.setModel(modelo4);
            
              
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnañadirfxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnañadirfxActionPerformed
        // TODO add your handling code here:
         ArrayList vector1=new ArrayList();
       String dato1= txtfx.getText();
       vector1.add(dato1);
       modelo5.addElement(vector1);
       jlistfx.setModel(modelo5);
        
    }//GEN-LAST:event_btnañadirfxActionPerformed

    private void jchingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchingresarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jchingresarActionPerformed

    
    public static void main(String args[]) {
     
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FuncionMetNumericos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionMetNumericos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionMetNumericos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionMetNumericos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionMetNumericos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnañadirfx;
    private javax.swing.JLabel btnañadirx;
    private javax.swing.JButton btntrapecio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JCheckBox jchingresar;
    private javax.swing.JLabel jlabelmetodo;
    private javax.swing.JLabel jlbresultado;
    private javax.swing.JList jlistfx;
    private javax.swing.JList jlistintegrales;
    private javax.swing.JList jlistx;
    private javax.swing.JTextField txtfuncion;
    private javax.swing.JTextField txtfx;
    private javax.swing.JTextField txth;
    private javax.swing.JTextField txtn;
    private javax.swing.JTextField txtsumatoria;
    private javax.swing.JTextField txtvalora;
    private javax.swing.JTextField txtvalorb;
    private javax.swing.JTextField txtx;
    // End of variables declaration//GEN-END:variables
//Plot2DPanel grafica= new Plot2DPanel();

}

