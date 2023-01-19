
package juegomemoria;

//librerias
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class menuinicio extends JFrame implements ActionListener {
    JLabel nomjudador,etiqueta;
    JButton creditos,iniciarjuego,salir;
    JTextField txtnomjugador;
   
    public menuinicio(){
        this.setTitle("Menu");
        this.setSize(1010, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        
        componentes();
    }
    
    //metodo que contiene todos los compoenentes de la ventana
    
    public void componentes(){
        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(30, 150, 30));
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        etiqueta = new JLabel("Memoria");
        etiqueta.setBounds(430,60,250,100);
        etiqueta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
        panel.add(etiqueta);
        
        etiqueta = new JLabel("Nombre");
        etiqueta.setBounds(450,250,250,40);
        etiqueta.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 20));
        panel.add(etiqueta);
        
        //texto donde se coloca el nombre de jugador
        txtnomjugador = new JTextField();
        txtnomjugador.setBounds(300,300,400,40);
        txtnomjugador.setHorizontalAlignment(JTextField.CENTER);
        txtnomjugador.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 20));
        panel.add(txtnomjugador);
        
        //boton iniciar juego, este mandara directamente a iniciar el juego 
        iniciarjuego = new JButton("Jugar");
        iniciarjuego.setBounds(370,400,250,40);
        iniciarjuego.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
        iniciarjuego.addActionListener(this);
        panel.add(iniciarjuego);
        
        
      
        
        
        //Boton salir
        salir = new JButton("Salir");
        salir.setBounds(370,480,250,40);
        salir.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
        salir.addActionListener(this);
        panel.add(salir);
        
        
    }
    
    //eventos de acción

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //este evento realiza la acción del boton iniciar juego
       if(e.getSource() == iniciarjuego){
           
           //se coloca un if para colocar una excepcion a la hora de iniciar el juego 
             if(txtnomjugador.getText().equals("")){
                 //si en el txtnomjugador no se encuentra ningun valor
             JOptionPane.showMessageDialog(null, "Coloca nombre de jugador");
             //mandara un mensaje diciendo que tiene que colocar algun nombre
            }else{
                 //de lo contrario, se inicializara el juego de memoria
                 //se manda a llamar la clase JuegoMemoria
                 JuegoMemoria ventana = new JuegoMemoria();
                 //decimos que nombreju de la clase JuegoMemoria 
                 //va a obtener el valor que se coloco en el txtnomjugador
                 ventana.nombreju.setText(txtnomjugador.getText());
                 //esto se coloca para inicializar el tiempo de la clase JuegoMemoria
                 ventana.tiempo.start();
                 //mostramos la ventana de la clase JuegoMemoria
                 ventana.setVisible(true);
                 //ocultamos la ventana de menuinicial
                 this.setVisible(false);
                 
                 
             }
        }
       
       //este es el evento de el boton creditos
      
       
       //este es el evento del boton salir 
       if(e.getSource() == salir){
           //se mostrara una ventana donde hace una pregunta y tiene las opciones de salir o no
           if (JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro de querer salir de la aplicacion?",
                "Salir de la Calculadora", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
                System.exit(0);
       }
      
    }
}
