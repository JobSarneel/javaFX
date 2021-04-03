package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Main extends Application {
	
	// small change, just to test GIT
	
	// not sure this is the right approach, but at least the label is visible for
	// the compute() method in this manner...
	Label label = new Label("");
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			// set the title of the primary stage
			primaryStage.setTitle("My First JavaFX App");
			primaryStage.initStyle(StageStyle.DECORATED);
	        
			// create two fields
			TextField textField = new TextField("0");
			TextField textField2 = new TextField("0");
			
			// listener for the first field
	        textField.textProperty()
	                 .addListener((observable, oldValue, newValue) -> {
	            String a = (newValue == "") ? "0" : newValue;
	            String b = (textField2.getText() == "") ? "0" : textField2.getText();
	            compute(a,b);
	        });
	        
	        // listener for the second field
	        textField2.textProperty()
	                  .addListener((observable, oldValue, newValue) -> {
	            String a = (textField.getText() == "") ? "0" : textField.getText();	            		
	            String b = (newValue == "") ? "0" : newValue;
	            compute(a,b);
	        });

	        // instantiate a root
	        Pane root = new Pane();
	        
	        // position our nodes (if that's the right term)
	        textField.setLayoutX(20);
			textField.setLayoutY(20);
	        textField2.setLayoutX(20);
			textField2.setLayoutY(50);
			label.setLayoutX(20);
			label.setLayoutY(80);
			
			// add the nodes to the root
	        root.getChildren().add(textField);
	        root.getChildren().add(textField2);
	        root.getChildren().add(label);
	        
	        // add root to scene, and scene to stage
	        primaryStage.setScene(new Scene(root, 300, 250));
	        
	        // launch
	        primaryStage.show();
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void compute(String a, String b) {
		int a1 = Integer.parseInt(a);
		int b1 = Integer.parseInt(b);
		int c = a1*b1;
		label.setText(String.valueOf(c));		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
