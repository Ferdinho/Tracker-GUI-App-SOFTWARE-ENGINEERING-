package sensor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class SensorApplication extends JFrame {
	
	public SensorApplication() {
		Adapter adapter = new Adapter();
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3,1));

		double radiationValue = adapter.getRadiationValue();
		Sensors  radiationPnl = new Sensors(adapter.getStatusInfo());
		String format = adapter.getName()+"("+adapter.getStatusInfo()+")"+"-->"+radiationValue;;
	    JLabel radiationLabel = new JLabel(format);
	    radiationPnl.add(radiationLabel);
		
	    double tempValue = adapter.senseTemperature();
	    Sensors  temperaturePnl = new Sensors(adapter.getTempReport());
		format = adapter.getSensorType()+"("+adapter.getTempReport()+")"+"-->"+tempValue;
		JLabel tempLabel = new JLabel(format);
		temperaturePnl.add(tempLabel);
		
		double PressureValue = adapter.readValue();
		Sensors  pressurePnl = new Sensors(adapter.getReport());
	    format = adapter.getSensorName()+"("+adapter.getReport()+")"+"-->"+PressureValue;
		JLabel pressureLabel = new JLabel(format);
	    pressurePnl.add(pressureLabel);
		
		
		radiationPnl.setBorder(new TitledBorder("Radiation Sensor"));
		add(radiationPnl);
		
		temperaturePnl.setBorder(new TitledBorder("Temperature Sensor"));
		add(temperaturePnl);
		
		pressurePnl.setBorder(new TitledBorder("Pressure Sensor"));
		add(pressurePnl);
		
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();
		TemperatureSensor temperature = new TemperatureSensor();
		System.out.print(temperature.getTempReport());
		
	}
	
	private class Sensors extends JPanel{
		
		String status;
		public Sensors(String status) {
			this.status = status;
		}
		
		public void paint(Graphics g) {
			super.paint(g);
			g.drawRect(30, 50, 200, 100);
			if(status.equals("OK"))
				g.setColor(Color.GREEN);
			else
				g.setColor(Color.RED);
			g.fillRect(30, 50, 200, 100);
		}
		
	}

}
