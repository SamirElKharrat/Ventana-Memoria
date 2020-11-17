package dad.ventana.memoria;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class MemoriaModel {
	private IntegerProperty red = new SimpleIntegerProperty();
	private IntegerProperty green = new SimpleIntegerProperty();
	private IntegerProperty blue = new SimpleIntegerProperty();
	private DoubleProperty altura = new SimpleDoubleProperty();
	private DoubleProperty anchura = new SimpleDoubleProperty();
	private DoubleProperty locationX = new SimpleDoubleProperty();
	private DoubleProperty locationY = new SimpleDoubleProperty();
	
	
	public final IntegerProperty redProperty() {
		return this.red;
	}
	
	public final int getRed() {
		return this.redProperty().get();
	}
	
	public final void setRed(final int red) {
		this.redProperty().set(red);
	}
	
	public final IntegerProperty greenProperty() {
		return this.green;
	}
	
	public final int getGreen() {
		return this.greenProperty().get();
	}
	
	public final void setGreen(final int green) {
		this.greenProperty().set(green);
	}
	
	public final IntegerProperty blueProperty() {
		return this.blue;
	}
	
	public final int getBlue() {
		return this.blueProperty().get();
	}
	
	public final void setBlue(final int blue) {
		this.blueProperty().set(blue);
	}
	
	public final DoubleProperty alturaProperty() {
		return this.altura;
	}
	
	public final double getAltura() {
		return this.alturaProperty().get();
	}
	
	public final void setAltura(final double altura) {
		this.alturaProperty().set(altura);
	}
	
	public final DoubleProperty anchuraProperty() {
		return this.anchura;
	}
	
	public final double getAnchura() {
		return this.anchuraProperty().get();
	}
	
	public final void setAnchura(final double anchura) {
		this.anchuraProperty().set(anchura);
	}
	
	public final DoubleProperty locationXProperty() {
		return this.locationX;
	}
	
	public final double getLocationX() {
		return this.locationXProperty().get();
	}
	
	public final void setLocationX(final double locationX) {
		this.locationXProperty().set(locationX);
	}
	
	public final DoubleProperty locationYProperty() {
		return this.locationY;
	}
	
	public final double getLocationY() {
		return this.locationYProperty().get();
	}
	
	public final void setLocationY(final double locationY) {
		this.locationYProperty().set(locationY);
	}
	
	
	

}
