// Michael Kulikowski
// UIC Cs342
// Project 2: GUI Keno Game

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;

import java.util.Random;

public class JavaFXTemplate extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	private Button rulesButton;
	private Button oddsButton;
	private Button exitButton;
	private Button readyButton;
	private Button playButton;
	private Button gameButton;
	private Button button1;
	private Button button4;
	private Button button8;
	private Button button10;
	private Button drawings1;
	private Button drawings2;
	private Button drawings3;
	private Button drawings4;
	private Button choose4Me;
	private Button nextDrawing;
	private Button newLookButton;
	private HBox menu;
	private HBox gameMenu;
	private VBox gamePrompts;
	private BorderPane bp;
	private BorderPane content;
	private BorderPane gamePane;
	private Text total;
	private VBox info;
	public int dollarAmount;
	private int numberOfSpots;
	private int spots;
	private int numberOfDrawings;
	private int drawing;
	private int blue = 0;
	VBox resultsScreen;
	ArrayList<Integer> chosenNumbers = new ArrayList<Integer>();

	public ArrayList<Integer> RandomInts20(int amount){
		ArrayList<Integer> randomInts = new ArrayList<Integer>();
		Random num = new Random();
		while (randomInts.size() < amount){
			int randomInt = num.nextInt(81);
			if (!randomInts.contains(randomInt)){
				randomInts.add(randomInt);
			}
		}
		return randomInts;
	}

	ArrayList<Integer> matchingNumbers(ArrayList<Integer> chosenNumbers, ArrayList<Integer> randomInts){
		ArrayList<Integer> matches = new ArrayList<Integer>();
		for (int i = 0; i < randomInts.size(); i++){
			for (int j = 0; j < chosenNumbers.size(); j++){
				if (randomInts.get(i) == chosenNumbers.get(j)){
					matches.add(randomInts.get(i));
				}
			}
		}
		return matches;
	}

	public void displayResults(ArrayList<Integer> matches){
		Text whatYouMatched = new Text();
		whatYouMatched.setText("Numbers you matched: " + matches);
		Text resultsTitle = new Text();
		resultsTitle.setFont(new Font(20));
		resultsTitle.setText("Your Results!");
		Text cusion = new Text();
		cusion.setFont(new Font(15));
		cusion.setText(" ");
		Text cusion2 = new Text();
		cusion2.setFont(new Font(10));
		cusion2.setText(" ");
		Text cusion3 = new Text();
		cusion3.setFont(new Font(10));
		cusion3.setText(" ");
		Text whatYouEarned = new Text();
		whatYouEarned.setText("What you earned: $" + (4 * matches.size()));
		dollarAmount = dollarAmount + 4 * matches.size();
		nextDrawing = new Button("Next Drawing");
		nextDrawing.setOnAction(drawingResults);
		resultsScreen = new VBox();
		resultsScreen.getChildren().addAll(cusion2, resultsTitle, cusion, whatYouMatched, whatYouEarned, cusion3, nextDrawing);
		content.setCenter(resultsScreen);
	}

	private void calculateResults(ArrayList<Integer> chosenNumbers, int numberOfDrawings){
		//generate our 20 random ints
		ArrayList<Integer> randomInts = RandomInts20(20);
		//compare against our arraylist
		ArrayList<Integer> matches = matchingNumbers(chosenNumbers, randomInts);
		//display results
		displayResults(matches);
		drawing++;
	}

	EventHandler<ActionEvent> drawingResults = new EventHandler<ActionEvent>(){
		public void handle(ActionEvent click){
			calculateResults(chosenNumbers, numberOfDrawings);
			if (drawing == numberOfDrawings){
				resultsScreen.getChildren().remove(nextDrawing);
				Button total = new Button("Final Results");
				total.setOnAction(finalResults);
				resultsScreen.getChildren().addAll(total);
			}
		}
	};

	EventHandler<ActionEvent> finalResults = new EventHandler<ActionEvent>(){
		public void handle(ActionEvent click){
			Text totalTitle = new Text();
			totalTitle.setFont(new Font(20));
			totalTitle.setText("What You Have Won So Far!");
			Text cusion = new Text();
			cusion.setFont(new Font(15));
			cusion.setText(" ");
			Text cusion2 = new Text();
			cusion2.setFont(new Font(10));
			cusion2.setText(" ");
			Text cusion3 = new Text();
			cusion3.setFont(new Font(15));
			cusion3.setText(" ");
			Text totalMoney = new Text();
			totalMoney.setText("Total Winnings: $" + dollarAmount);
			Button playAgain = new Button("Play Again?");
			playAgain.setOnAction(restartGame);
			VBox finalTotals = new VBox();
			finalTotals.getChildren().addAll(cusion2, totalTitle, cusion, totalMoney, cusion3, playAgain);
			content.setCenter(finalTotals);
		}
	};

	EventHandler<ActionEvent> restartGame = new EventHandler<ActionEvent>(){
		public void handle(ActionEvent click){
			chosenNumbers.clear();
			drawing = 0;
			spots = 0;
			total.setText("Total earnings: $" + dollarAmount);
			content.setCenter(gamePrompts);
			content.setRight(null);
			
		}
	};

	private void makeButtonGrid(){
		VBox grid = new VBox();
		HBox row = new HBox();
		int gridNumber = 0;
		for (int i = 1; i < 9; i++){
			for (int j = 1; j < 11; j++){
				Button gridButton = new Button(String.valueOf(j + gridNumber));
				gridButton.setOnAction(gridHandler);
				row.getChildren().addAll(gridButton);
			}
			grid.getChildren().addAll(row);
			row = new HBox();
			gridNumber = gridNumber + 10;
		}
		GridPane buttonGrid = new GridPane();
		Button lockIn = new Button("Lock In");
		lockIn.setOnAction(drawingResults);
		choose4Me = new Button("Choose for me");
		choose4Me.setOnAction(e -> {
			chosenNumbers = RandomInts20(numberOfSpots);
			grid.setDisable(true);
		});
		
		grid.getChildren().addAll(buttonGrid);
		HBox gridOptions = new HBox();
		VBox gameScreen = new VBox();
		Text gridTitle = new Text();
		Text cusion = new Text();
		cusion.setFont(new Font(10));
		cusion.setText(" ");
		Text cusion2 = new Text();
		cusion2.setFont(new Font(30));
		cusion2.setText(" ");
		Text cusion3 = new Text();
		cusion3.setFont(new Font(15));
		cusion3.setText(" ");
		gridTitle.setFont(new Font(20));
		gridTitle.setText("Play Card");
		gridOptions.getChildren().addAll(choose4Me, lockIn);
		gameScreen.getChildren().addAll(cusion, gridTitle, cusion3, grid, cusion2, gridOptions);
		content.setCenter(gameScreen);
	}

	
	
	EventHandler<ActionEvent> spotsHandler = new EventHandler<ActionEvent>(){
		public void handle(ActionEvent click){
			Button tempButton = (Button) click.getTarget();
			numberOfSpots = Integer.parseInt(tempButton.getText());
			HBox drawingsOptions = new HBox();
			drawingsOptions.getChildren().addAll(drawings1,drawings2,drawings3,drawings4);
			Text cusion = new Text();
			cusion.setFont(new Font(30));
			cusion.setText(" ");
			Text cusion2 = new Text();
			cusion2.setFont(new Font(30));
			cusion2.setText(" ");
			Text drawingTitle = new Text();
			drawingTitle.setText("Number of Drawings");
			drawingTitle.setFont(new Font(20));
			VBox drawingPrompt = new VBox();
			drawingPrompt.getChildren().addAll(cusion, drawingTitle, cusion2, drawingsOptions);
			content.setCenter(drawingPrompt);
		}
	};

	EventHandler<ActionEvent> drawingsHandler = new EventHandler<ActionEvent>(){
		public void handle(ActionEvent click){
			Button tempButton = (Button) click.getTarget();
			numberOfDrawings = Integer.parseInt(tempButton.getText());
			makeButtonGrid();
		}
	};

	EventHandler<ActionEvent> gridHandler = new EventHandler<ActionEvent>(){
		public void handle(ActionEvent press){
			Button tempButton = (Button) press.getTarget();
			int numberPressed = Integer.parseInt(tempButton.getText());
			if (chosenNumbers.contains(numberPressed)){
				for (int i = 0; i < chosenNumbers.size(); i++){
					if (chosenNumbers.get(i) == numberPressed){
						chosenNumbers.remove(i);
						spots--;
						tempButton.setStyle(null);
					}
				}
			}else{
				if(spots < numberOfSpots){
					chosenNumbers.add(numberPressed);
					spots++;
					tempButton.setStyle("-fx-background-color: #00FF00; ");
				}
			}
		}
	};
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Keno");

		rulesButton = new Button("Rules");
		oddsButton = new Button("The Odds");
		exitButton = new Button("Exit");
		readyButton = new Button("Game Screen");
		playButton = new Button("Play Game");
		Button gameRules = new Button("rules");
		Button gameOdds = new Button("odds");
		gameButton = new Button("Game Screen");
		newLookButton = new Button("New Look ;)");
		
		Text menuText = new Text();
		menuText.setFont(new Font(17));
		menuText.setText("Menu: ");
		

		button1 = new Button("1");
		button4 = new Button("4");
		button8 = new Button("8");
		button10 = new Button("10");
		

		drawings1 = new Button("1");
		drawings2 = new Button("2");
		drawings3 = new Button("3");
		drawings4 = new Button("4");
		
		menu = new HBox();
		menu.getChildren().addAll(menuText, readyButton, rulesButton, oddsButton, exitButton);

		Text cusion = new Text();
		cusion.setFont(new Font(30));
		cusion.setText(" ");
		Text cusion2 = new Text();
		cusion2.setFont(new Font(30));
		cusion2.setText(" ");
		Text spotsTitle = new Text();
		spotsTitle.setText("Number of Spots");
		spotsTitle.setFont(new Font(20));
		HBox spotsOptions = new HBox();
		spotsOptions.getChildren().addAll(button1, button4, button8, button10);
		gamePrompts = new VBox();
		gamePrompts.getChildren().addAll(cusion, spotsTitle, cusion2, spotsOptions);

		dollarAmount = 0;
		
		bp = new BorderPane();
		gamePane = new BorderPane();
		content = new BorderPane();
		content.setCenter(playButton);

		bp.setTop(menu);
		bp.setCenter(content);

		

		button1.setOnAction(spotsHandler);
		button4.setOnAction(spotsHandler);
		button8.setOnAction(spotsHandler);
		button10.setOnAction(spotsHandler);

		drawings1.setOnAction(drawingsHandler);
		drawings2.setOnAction(drawingsHandler);
		drawings3.setOnAction(drawingsHandler);
		drawings4.setOnAction(drawingsHandler);

		

		rulesButton.setOnAction(e-> {
			info = new VBox();
			Text cusion4 = new Text();
			cusion4.setFont(new Font(10));
			cusion4.setText(" ");
			Text rulesTitle = new Text();
			rulesTitle.setFont(new Font(20));
			rulesTitle.setText("Game Rules");
			Text rules1 = new Text();
			rules1.setText("1. Decide how much to play per draw.");
			Text rules2 = new Text();
			rules2.setText("2. Select how many consecutive draws to play.");
			Text rules3 = new Text();
			rules3.setText("3. Select how many numbers to match from 1 to 10. Pick as many numbers as you did Spots.");
			info.getChildren().addAll(cusion4, rulesTitle, rules1,rules2, rules3);
			bp.setCenter(info);
		});

		gameRules.setOnAction(e -> {
			info = new VBox();
			Text cusion4 = new Text();
			cusion4.setFont(new Font(10));
			cusion4.setText(" ");
			Text rulesTitle = new Text();
			rulesTitle.setFont(new Font(20));
			rulesTitle.setText("Game Rules");
			Text rules1 = new Text();
			rules1.setText("1. Decide how much to play per draw.");
			Text rules2 = new Text();
			rules2.setText("2. Select how many consecutive draws to play.");
			Text rules3 = new Text();
			rules3.setText("3. Select how many numbers to match from 1 to 10. Pick as many numbers as you did Spots.");
			info.getChildren().addAll(cusion4, rulesTitle, rules1,rules2, rules3);
			gamePane.setCenter(info);
		});

		oddsButton.setOnAction(e-> {
			info = new VBox();
			Text cusion4 = new Text();
			cusion4.setFont(new Font(10));
			cusion4.setText(" ");
			Text oddsTitle = new Text();
			oddsTitle.setFont(new Font(20));
			oddsTitle.setText("Odds of Winning");
			Text odds1 = new Text();
			odds1.setText("Your chances of winning are 1 in 4, which calculates into an enormous 25% house percentage.");
			Text odds2 = new Text();
			odds2.setText("Thus you should plan to lose $25 for every $100 wagered.");
			Text odds3 = new Text();
			odds3.setText("If 22 is among the numbers drawn, you win your bet and $4 is how much you should get back.");
			Text sources = new Text();
			sources.setText("-Google");
			info.getChildren().addAll(cusion4, oddsTitle, odds1,odds2,odds3, sources);
			bp.setCenter(info);
		});

		gameOdds.setOnAction(e-> {
			info = new VBox();
			Text cusion4 = new Text();
			cusion4.setFont(new Font(10));
			cusion4.setText(" ");
			Text oddsTitle = new Text();
			oddsTitle.setFont(new Font(20));
			oddsTitle.setText("Odds of Winning");
			Text odds1 = new Text();
			odds1.setText("Your chances of winning are 1 in 4, which calculates into an enormous 25% house percentage.");
			Text odds2 = new Text();
			odds2.setText("Thus you should plan to lose $25 for every $100 wagered.");
			Text odds3 = new Text();
			odds3.setText("If 22 is among the numbers drawn, you win your bet and $4 is how much you should get back.");
			Text sources = new Text();
			sources.setText("-Google");
			info.getChildren().addAll(cusion4, oddsTitle, odds1,odds2,odds3, sources);
			gamePane.setCenter(info);
		});

		exitButton.setOnAction(e-> {
        	System.exit(0);
		});

		readyButton.setOnAction(e-> {
			content.setCenter(playButton);
			bp.setCenter(content);
		});

		gameButton.setOnAction(e-> {
			gamePane.setCenter(content);
		});

		Scene welcomeScene = new Scene(bp, 700,700);
		Scene gameScene = new Scene(gamePane, 700,700);
		primaryStage.setScene(welcomeScene);
		primaryStage.show();

		playButton.setOnAction(e-> {
			gameMenu = new HBox();
			Text gameMenuText = new Text();
			gameMenuText.setFont(new Font(17));
			gameMenuText.setText("Menu: ");
			gamePane.setTop(gameMenu);
			content.setCenter(gamePrompts);
			gamePane.setCenter(content);
			total = new Text();
			total.setFont(new Font(15));
			total.setText("Total earnings: $" + dollarAmount);
			gameMenu.getChildren().addAll(gameMenuText, gameButton, gameRules, gameOdds, newLookButton, exitButton, total);
			primaryStage.setScene(gameScene);			
		});

		newLookButton.setOnAction(e-> {
			if (blue == 0){
				gameButton.setFont(Font.font("Comic Sans MS"));
				gameRules.setFont(Font.font("Comic Sans MS"));
				gameOdds.setFont(Font.font("Comic Sans MS"));
				newLookButton.setFont(Font.font("Comic Sans MS"));
				exitButton.setFont(Font.font("Comic Sans MS"));
				total.setFont(Font.font("Comic Sans MS"));
				gamePane.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
				Text imBlue = new Text();
				imBlue.setFont(new Font(30));
				imBlue.setText("I'm blue dah bah dee dah bu die");
				content.setBottom(imBlue);
				blue = 1;
			}else{
				gameButton.setFont(Font.font(null));
				gameRules.setFont(Font.font(null));
				gameOdds.setFont(Font.font(null));
				newLookButton.setFont(Font.font(null));
				exitButton.setFont(Font.font(null));
				total.setFont(Font.font(null));
				gamePane.setBackground(new Background(new BackgroundFill(null, null, null)));
				content.setBottom(null);
				blue = 0;
			}
		});
	}
}
