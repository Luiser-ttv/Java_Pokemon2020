
package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;

/**
 *
 * @author xp
 */
public class VentanaPokedex extends javax.swing.JFrame {

    BufferedImage buffer1 = null;
    Image imagen1 = null;
    int contador = 0;
    
    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;
    
    
    @Override
    public void paint(Graphics g){
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) imagenPokemon.getGraphics();
        g2.drawImage(buffer1, 0, 0,
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight(), null);
    }
    
    /**
     * Creates new form VentanaPokedex
     */
    public VentanaPokedex() {
        initComponents();
        try {
            imagen1 = ImageIO.read(getClass()
                    .getResource("/imagenes/black-white.png"));
        } catch (IOException ex) {
        }
        
        buffer1 = (BufferedImage) imagenPokemon.createImage(
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight());
        Graphics2D g2 = buffer1.createGraphics();
        
        dibujaElPokemonQueEstaEnLaPosicion(30);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1/test",
                            "root",
                            "");
            estado = conexion.createStatement();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("hay un error");
        }
    }

    private void dibujaElPokemonQueEstaEnLaPosicion(int posicion){
        int fila = posicion / 31;
        int columna = posicion % 31;
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.black);
        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight()); 
        g2.drawImage(imagen1,
                0,  //posicion X inicial dentro del jpanel 
                0,  // posicion Y inicial dentro del jpanel
                imagenPokemon.getWidth(), //ancho del jpanel
                imagenPokemon.getHeight(), //alto del jpanel
                columna*96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila*96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna*96 + 96, //posicion final X
                fila*96 + 96, //posicion final Y
                null  //si no lo pones no va
                );
        repaint();
        
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenPokemon = new javax.swing.JPanel();
        izq = new javax.swing.JButton();
        der = new javax.swing.JButton();
        nombrePokemon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout imagenPokemonLayout = new javax.swing.GroupLayout(imagenPokemon);
        imagenPokemon.setLayout(imagenPokemonLayout);
        imagenPokemonLayout.setHorizontalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );
        imagenPokemonLayout.setVerticalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );

        izq.setText("<");
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });

        der.setText(">");
        der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(izq, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(der, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imagenPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(nombrePokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagenPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombrePokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(izq, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(der, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
        contador --;
        if (contador <=0){
            contador = 1;
        }
        dibujaElPokemonQueEstaEnLaPosicion(contador);
    }//GEN-LAST:event_izqActionPerformed

    private void derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derActionPerformed
        contador ++;
        if (contador >=649){
            contador = 649;
        }
        dibujaElPokemonQueEstaEnLaPosicion(contador);
    }//GEN-LAST:event_derActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton der;
    private javax.swing.JPanel imagenPokemon;
    private javax.swing.JButton izq;
    private javax.swing.JLabel nombrePokemon;
    // End of variables declaration//GEN-END:variables
}
