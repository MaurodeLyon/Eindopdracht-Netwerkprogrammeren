package view;


import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FontLoader {
	
	public static Font customFont;
	
	public static void loadFont()
	{
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT,FontLoader.class.getResourceAsStream("/PressStart2P.ttf")).deriveFont(40f); 
			
			GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(customFont); 
			//ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,FontLoader.class.getResourceAsStream("/font/PressStart2P.ttf")));
		} catch (IOException|FontFormatException e) {
		     //Handle exception
			System.out.println("OOPS,font not found!");
		}

	}

}
