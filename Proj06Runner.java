import java.awt.Frame;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Proj06Runner extends Frame{
  public static void main(String[] args){
    Frame aFrame = new Proj06Runner();
  }//end main 
  
    /*--------------------------------------------------*/
  
  public Proj06Runner(){//Constructor 
    //Assignment specifications require this text be output to the console
    System.out.println("Proj06");
    System.out.println("I certify that this program is my own work\n" +
                       "and is not the work of others. I agree not\n" +
                       "to share my solution with others.\n" +
                       "Arianna Haradon\n");
    System.out.println();
    
    
    //Initialize GUI Elements 
    TextField myTextField = new TextField("This TextField does nothing");
    Button myButton = new Button("This Button does nothing");
    myButton.setName("Button1");
    Button myButton2 = new Button("Button");
    myButton2.setName("Button2");
    MyPanel myPanel = new MyPanel(); 
    
    
    MyFrame display = new MyFrame();
    display.setSize(300,200);
    display.setTitle("Arianna Haradon");
    display.setName("DisplayName");
    display.add(myPanel);
    display.add("North",myButton);
    display.add("West", myButton2);
    display.add("South",myTextField);
    display.setVisible(true); 
                                            
                                                                                 
    display.addWindowListener(new WProc1()); //Ends program when user clicks the X button
    
    myPanel.addMouseMotionListener(new MouseHandler(myPanel));//Listens for mouse actions on myPanel 
     
  } // end constructor
  
  /*--------------------------------------------------*/
 
  //This class has two mouse listeners on MyPanel
  //Both listeners display the coordinates of the mouse
  
class MouseHandler extends MouseAdapter{
  MyPanel refToWin; //save a reference to the source (MyPanel) here
  
  MouseHandler(MyPanel inWin){//constructor
    refToWin = inWin;//save ref to window
  }//end constructor
  
  
 public void mouseMoved(MouseEvent e){
    //Get X and Y coordinates of mouse pointer and store
    // in an instance variable of the Frame object
    refToWin.setForeground(Color.BLACK); //set text color
    refToWin.clickX = e.getX();
    refToWin.clickY = e.getY();

    //Force the Frame object to be repainted everytime the mouse moves 
    // in order to display the changing coordinate information.
    refToWin.repaint();
  }//end mouseMoved
  
   public void mouseDragged(MouseEvent e){
    //Get X and Y coordinates of mouse pointer and store
    // in an instance variable of the Frame object
    refToWin.setForeground(Color.RED); //set text color
    refToWin.clickX = e.getX();
    refToWin.clickY = e.getY();

    //Force the Frame object to be repainted everytime the mouse is dragged
    // in order to display the changing coordinate information.
    refToWin.repaint();
  }//end mouseDragged()
}
 
  /*--------------------------------------------------*/

}
//Subclass Panel in order to override the paint method.
class MyPanel extends Panel{
   int clickX;
   int clickY;

  public void paint(Graphics g){
   g.drawString(
             "" + clickX + ", " + clickY, clickX, clickY);
  }//end paint()
  
}


//Subclass Frame in order to override the paint method.
class MyFrame extends Frame{
   int clickX;
   int clickY;

  public void paint(Graphics g){
   g.drawString(
             "" + clickX + ", " + clickY, clickX, clickY);
  }//end paint()
  
}
  /*--------------------------------------------------*/

//Window Listener to close window.
class WProc1 extends WindowAdapter{
  @Override
  public void windowClosing(WindowEvent e){
    System.exit(0);
  }//end windowClosing()
}//end class WProc1
