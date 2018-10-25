//Box.java - Define Box	class
public class Box
{
//Declare attributes	(instance field/variables)
private int	width;
private int	height;
private int	depth;
//Constructor method	taking three parameters
public Box(int	w,	int h, int d)
{
	width	= w;
	height =	h;
	depth	= d;
}
//Getter	method for height
public int getHeight()
{
return height;
}
public int getWidth()
{
return width;
}
public int getDepth()
{
return depth;
}

 //Calculate the volume	of	this box
public int calculateVolume()
{
return height * width *	depth;
}
 public int calculateSurfaceArea(){
      return (2 *width * depth) + (2*width*height) + (2*height*depth);
 
 }
}

//TestBox.java: write a	separate	class	to	demonstrate	creating	& using an object
class	TestBox
{
//Main method testing the Box	class
public static void main(String[]	args)
{
Box myBox =	new Box(2, 3, 4);	//create	a Box	object
 System.out.println(myBox.calculateVolume());
 System.out.println(myBox.calculateSurfaceArea());
 String[] month  = {"Jan", "Feb", "March", "April", "May", "June","July", "Aug", "Sept", "Oct", "Nov", "Dec"}; 

 }
 

}