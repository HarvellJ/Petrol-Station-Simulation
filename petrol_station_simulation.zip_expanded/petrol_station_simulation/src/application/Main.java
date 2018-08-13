package application;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.Window;
import petrolStationSimulation.PetrolStationSimulator;
import petrolStationSimulation.PetrolStation.PetrolStation;
import petrolStationSimulation.PetrolStation.ShoppingArea;
import simulator.Simulator;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {				
		    GridPane gridPane = this.createConfigurationForm();
		    addUIControls(gridPane);
		    
			Scene scene = new Scene(gridPane,800,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private GridPane createConfigurationForm() {

		GridPane gridPane = new GridPane();

	    gridPane.setAlignment(Pos.CENTER);

	    gridPane.setPadding(new Insets(40, 40, 40, 40));

	    // Set the vertical gap between rows
	    gridPane.setVgap(6);
	    
	    // Set the horizontal gap between columns
	    gridPane.setHgap(10);

	    ColumnConstraints columnConstraintsFirst = new ColumnConstraints(200, 200, Double.MAX_VALUE);
	    columnConstraintsFirst.setHalignment(HPos.RIGHT);

	    ColumnConstraints columnConstraintsSecond = new ColumnConstraints(100,100, Double.MAX_VALUE);
	    columnConstraintsSecond.setHgrow(Priority.ALWAYS);

	    gridPane.getColumnConstraints().addAll(columnConstraintsFirst, columnConstraintsSecond);
	    
	    return gridPane;
	}
	
	private void addUIControls(GridPane gridPane) {
	    // Add Header
	    Label headerLabel = new Label("Petrol Station Simulator");
	    headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
	    gridPane.add(headerLabel, 0,0,2,1);
	    GridPane.setHalignment(headerLabel, HPos.CENTER);
	    GridPane.setMargin(headerLabel, new Insets(20, 0, 20,0));
    
	    // Add pumps Label
	    Label numOfPumpsLabel = new Label("Number of pumps: ");
	    gridPane.add(numOfPumpsLabel, 0,1);

	    // Add pumps Text Field
	    TextField numOfPumps = new TextField();
	    numOfPumps.setPrefHeight(40);
	    gridPane.add(numOfPumps, 1,1);

	    // Add tills Label
	    Label numOfTillsLabel = new Label("Number of tills: ");
	    gridPane.add(numOfTillsLabel, 0, 2);

	    // Add tills Text Field
	    TextField numOfTills = new TextField();
	    numOfTills.setPrefHeight(40);
	    gridPane.add(numOfTills, 1, 2);

	    // Add trucksAllowed Label
	    Label trucksAllowedLabel = new Label("Trucks enabled: ");
	    gridPane.add(trucksAllowedLabel, 0, 3);

	    // Add trucksAllowed Text Field
	    RadioButton radioTrucksEnabled = new RadioButton("Enabled");
        RadioButton radioTrucksDisabled = new RadioButton("Disabled");
        ToggleGroup radioTruck = new ToggleGroup();
        radioTrucksEnabled.setToggleGroup(radioTruck);
        radioTrucksDisabled.setToggleGroup(radioTruck);
        radioTruck.selectToggle(radioTrucksEnabled); //default trucks to enabled
        HBox hbox = new HBox(radioTrucksEnabled, radioTrucksDisabled);
        gridPane.add(hbox, 1, 3);
	    
	    // Add probabilitySmallCarsAndBikes Label
	    Label probabilitySmallCarsAndBikesLabel = new Label("Probability small cars and bikes (double): ");
	    gridPane.add(probabilitySmallCarsAndBikesLabel, 0, 4);

	    // Add probabilitySmallCarsAndBikes Text Field
	    TextField probabilitySmallCarsAndBikes = new TextField();
	    probabilitySmallCarsAndBikes.setPromptText("e.g. 0.2");
	    probabilitySmallCarsAndBikes.setPrefHeight(40);
	    gridPane.add(probabilitySmallCarsAndBikes, 1, 4);
	    
	    // Add probabilityFamilySedanLabel Label
	    Label probabilityFamilySedanLabel = new Label("Probability family sedan (double): ");
	    gridPane.add(probabilityFamilySedanLabel, 0, 5);

	    // Add probabilityFamilySedanLabel Text Field
	    TextField probabilityFamilySedan = new TextField();
	    probabilityFamilySedan.setPromptText("e.g. 0.4");
	    probabilityFamilySedan.setPrefHeight(40);
	    gridPane.add(probabilityFamilySedan, 1, 5);
	    
	    // Add probabilityFamilySedanLabel Label
	    Label desiredSimulationDurationLabel = new Label("Simulation duration (seconds): ");
	    gridPane.add(desiredSimulationDurationLabel, 0, 6);

	    // Add desiredSimulationDuration Text Field
	    TextField desiredSimulationDuration = new TextField();
	    desiredSimulationDuration.setPromptText("e.g. 14400 (4 hours)");
	    desiredSimulationDuration.setPrefHeight(40);
	    gridPane.add(desiredSimulationDuration, 1, 6);
	    
	    // Add probabilityFamilySedanLabel Label
	    Label tickTimeLabel = new Label("Tick duration (seconds): ");
	    gridPane.add(tickTimeLabel, 0, 7);

	    // Add desiredSimulationDuration Text Field
	    TextField tickTime = new TextField();
	    tickTime.setPromptText("how often the simulation will tick");
	    tickTime.setPrefHeight(40);
	    gridPane.add(tickTime, 1, 7);
	    
	    // Add probabilityFamilySedanLabel Label
	    Label pricePerGalonLabel = new Label("Price per galon (double): ");
	    gridPane.add(pricePerGalonLabel, 0, 8);

	    // Add desiredSimulationDuration Text Field
	    TextField pricePerGalon = new TextField();
	    pricePerGalon.setPromptText("e.g. 1.20");
	    pricePerGalon.setPrefHeight(40);
	    gridPane.add(pricePerGalon, 1, 8);
	    
	    // Add probabilityFamilySedanLabel Label
	    Label randomSeedLabel = new Label("Random seed (long): ");
	    gridPane.add(randomSeedLabel, 0, 9);

	    // Add desiredSimulationDuration Text Field
	    TextField randomSeed = new TextField();
	    randomSeed.setPromptText("e.g. 1");
	    randomSeed.setPrefHeight(40);
	    gridPane.add(randomSeed, 1, 9);
	    
	    // Add probabilityFamilySedanLabel Label
	    Label outputFilePathLabel = new Label("Ouput file path (incl. file name): ");
	    gridPane.add(outputFilePathLabel, 0, 10);
	    
	    TextField outputFilePath = new TextField();
	    outputFilePath.setPromptText("'<filepath>\\<desiredFileName>' e.g. C:\\exampleFolder\\outputFileName");
	    outputFilePath.setPrefHeight(40);
	    gridPane.add(outputFilePath, 1, 10);
	    
	    // Add Submit Button
	    Button submitButton = new Button("Submit");
	    submitButton.setPrefHeight(40);
	    submitButton.setDefaultButton(true);
	    submitButton.setPrefWidth(100);
	    gridPane.add(submitButton, 0, 11, 2, 1);
	    GridPane.setHalignment(submitButton, HPos.CENTER);
	    GridPane.setMargin(submitButton, new Insets(20, 0,20,0));
	    
	    // Add probabilityFamilySedanLabel Label
	    Label runningLabel = new Label("");
	    gridPane.add(runningLabel, 0, 12);
	    
	    submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(numOfPumps.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "error", "Please enter value for number of pumps");
                    return;
                }
                else if(numOfTills.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "error", "Please enter value for number of tills");
                    return;
                }
                else if(probabilitySmallCarsAndBikes.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "error", "Please enter value for probability small cars and bikes");
                    return;
                }
                else if(probabilityFamilySedan.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "error", "Please enter value for probability family sedan");
                    return;
                }
                else if(desiredSimulationDuration.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "error", "Please enter value for simulation duration");
                    return;
                }
                else if(tickTime.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "error", "Please enter value for tick time");
                    return;
                }
                else if(pricePerGalon.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "error", "Please enter value for price per galon");
                    return;
                }
                else if(randomSeed.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "error", "Please enter value for random seed");
                    return;
                }
                else if(outputFilePath.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "error", "Please enter value for output file path");
                    return;
                }     
                else {
                    showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Simulation Started", "Running simulation...");

                	int configuredNumberOfTills = Integer.parseInt(numOfTills.getText());
                	int configuredNumberOfPumps = Integer.parseInt(numOfPumps.getText());
                	boolean configuredTrucksAllowed = radioTruck.getSelectedToggle().equals(radioTrucksEnabled);
                	double configuredProbabilitySmallCarsAndBikes = Double.parseDouble(probabilitySmallCarsAndBikes.getText());
                	double configuredProbabilityFamilySedan = Double.parseDouble(probabilityFamilySedan.getText());
                	int ConfiguredSimulationDuration = Integer.parseInt(desiredSimulationDuration.getText());
                	int ConfiguredTickTime = Integer.parseInt(tickTime.getText());
                	double configuredPricePerGalon = Double.parseDouble(pricePerGalon.getText());
                	long configuredRandomSeeed = Long.parseLong(randomSeed.getText());
                	String configuredFilePath = outputFilePath.getText();
                	
    				ShoppingArea shop = new ShoppingArea(configuredNumberOfTills);
    			    PetrolStation petrolStation = new PetrolStation(configuredNumberOfPumps, configuredTrucksAllowed, shop,
    			    		configuredPricePerGalon);
    				
    			    PetrolStationSimulator petrolStationSimulator = new PetrolStationSimulator(petrolStation, configuredProbabilitySmallCarsAndBikes, 
    			    		configuredProbabilityFamilySedan, configuredTrucksAllowed, configuredRandomSeeed,configuredFilePath);				    				    
    			    
    			    Simulator simulator = new Simulator(ConfiguredSimulationDuration, ConfiguredTickTime, petrolStationSimulator);
    				
    			 	simulator.startSimulation();	
                	
                    showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Finished Simulation", "You can find the output at: " + configuredFilePath);            
                }
              
                }
        });
    }

	  private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
	        Alert alert = new Alert(alertType);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(message);
	        alert.initOwner(owner);
	        alert.show();
	    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
