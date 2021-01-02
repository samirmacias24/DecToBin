package game;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DecToBin extends Application {
	public void start(Stage primaryStage) {
		try {
			Translate num = new Translate();
			Button button = exitButton();
			Pane pane = new Pane();	
			
			// adding background color
			Canvas canvas = new Canvas(1750,850);
			StackPane pane2 = new StackPane();
			pane2.getChildren().add(canvas);
			pane.getChildren().add(pane2);
			pane2.setStyle("-fx-background-color: bisque");
			
			pane.setPrefSize(600, 800);
			pane.getChildren().addAll(transform(num));
			pane.getChildren().add(button);
			
			Scene scene = new Scene(pane, 400, 400);
			primaryStage.setTitle("Dec_to_Bin.exe");
			primaryStage.setScene(scene);
			primaryStage.show(); // will display the stage		
			primaryStage.setResizable(false); // will not allow the the window to resize

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	// This method places a button at the corner
	// -> if clicked, the gui will close
	
	public Button exitButton()
	{
		// Button allows user to exit the program
		Button button = new Button("Exit");
		button.setTranslateX(182.5);
		button.setTranslateY(160);
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent arg0) {
				System.exit(0);
			}
		};
		button.setOnAction(event); // calls the action to occur
		return button;
	}
	
	// This method calculates the value from (decimal -> binary).
	// While also setting up key details in the stage.
	public ArrayList<Node> transform (Translate object)
	{
		ArrayList<Node> obj = new ArrayList<>();
		Label val = new Label("Decimal to Binary Converter\n     (Enter decimal value)");
		val.setTranslateX(70);
		val.setTranslateY(40);	
		final double MAX_FONT_SIZE = 20.0;  // makes text larger
		val.setFont(new Font(MAX_FONT_SIZE)); 
		val.setStyle("-fx-font-weight: bold"); // makes text bold
		
		TextField txt = new TextField();
		txt.setTranslateX(125);
		txt.setTranslateY(100);
		Button button = new Button("ENTER");
		button.setTranslateX(175);
		button.setTranslateY(130);
		Label input = new Label();  // Label is called when user clicks enter
		input.setTranslateX(135);
		input.setTranslateY(200);
		Label answer = new Label();
		answer.setTranslateX(135);
		answer.setTranslateY(220);
		Label wow = new Label();
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent arg0) {
				String inputName = txt.getText();  // retrieves text from user
				
				object.setBinary(inputName);
				String binary = object.getBinary();
				input.setText("Decimal: "+object.getDecimal());  
				input.setStyle("-fx-font-weight: bold");
				answer.setText("Binary: " + binary);
				answer.setStyle("-fx-font-weight: bold");
			}	
		};
		button.setOnAction(event);
		obj.add(val);
		obj.add(txt);
		obj.add(button);
		obj.add(input);	
		obj.add(answer);
		return obj;
	}
}