package dad.ventana.memoria;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Properties;

import javafx.beans.binding.Bindings;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Slider;

public class MemoriaController implements Initializable {
	
	private MemoriaModel model = new MemoriaModel();
	
	public MemoriaController(Properties pro) throws IOException {
		
		model.setRed(Integer.valueOf((String) pro.get("background.red")));
		model.setBlue(Integer.valueOf((String) pro.get("background.blue")));
		model.setGreen(Integer.valueOf((String) pro.get("background.green")));
		model.setAltura(Double.valueOf((String) pro.get("size.height")));
		model.setAnchura(Double.valueOf((String) pro.get("size.width")));
		model.setLocationX(Double.valueOf((String) pro.get("location.x")));
		model.setLocationY(Double.valueOf((String) pro.get("location.y")));
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
		
	}

	@FXML
	private VBox view;
	
	@FXML
	private Slider red;
	
	@FXML
	private Slider blue;
	
	@FXML
	private Slider green;
	
	private Stage stage;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Bindings.bindBidirectional(red.valueProperty(), model.redProperty());
		Bindings.bindBidirectional(blue.valueProperty(), model.blueProperty());
		Bindings.bindBidirectional(green.valueProperty(), model.greenProperty());
		
		red.valueProperty().addListener(e -> onSliderCambiarValor(e));
		green.valueProperty().addListener(e -> onSliderCambiarValor(e));
		blue.valueProperty().addListener(e -> onSliderCambiarValor(e));
		
		view.setStyle("-fx-background-coloer; rgb(" + model.getRed() + "," + model.getGreen() + "," + model.getBlue() + ");");
		
	}
	
	public void onSliderCambiarValor(Observable e) {
		view.setStyle("-fx-background-coloer; rgb(" + model.getRed() + "," + model.getGreen() + "," + model.getBlue() + ");");
	}
	
	public void ListenerStage(Stage primaryStage) {
		stage = primaryStage;
		
		stage.widthProperty().addListener(e -> onSizeCambiarValor(e));
		stage.heightProperty().addListener(e -> onSizeCambiarValor(e));
		
		stage.xProperty().addListener(e -> onLocationCambiarValor(e));
		stage.yProperty().addListener(e -> onLocationCambiarValor(e));
	}
	
	
	public void onSizeCambiarValor(Observable e) {
		model.setAnchura(stage.getWidth());
		model.setAltura(stage.getHeight());
		
	}
	
	public void onLocationCambiarValor(Observable e) {
		model.setLocationX(stage.getX());
		model.setLocationY(stage.getY());
	}
	
	public VBox getView() {
		return view;
	}
	
	public void setView() {
		this.view = view;
	}
	
	public MemoriaModel getModel() {
		return model;
	}
	
	public void setModel() {
		this.model = model;
	}

}
