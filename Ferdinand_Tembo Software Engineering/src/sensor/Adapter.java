package sensor;

public class Adapter implements myInterface{
	PressureSensor pressureS;
	RadiationSensor radiationS;
	TemperatureSensor temperatureS;
	
	
	public Adapter () {
		pressureS = new PressureSensor();
		radiationS = new RadiationSensor();
		temperatureS = new TemperatureSensor();
		
	}
	

	@Override
	public double senseTemperature() {
		return temperatureS.senseTemperature();
	}

	@Override
	public String getTempReport() {
		return temperatureS.getTempReport();
	}

	@Override
	public String getSensorType() {
		return temperatureS.getSensorType();
	}

	@Override
	public double getRadiationValue() {
		return radiationS.getRadiationValue();
	}

	@Override
	public String getStatusInfo() {
		return radiationS.getStatusInfo();
	}

	@Override
	public String getName() {
		return radiationS.getName();
	}

	@Override
	public double readValue() {
		return pressureS.readValue();
	}

	@Override
	public String getReport() {
		return pressureS.getReport();
	}

	@Override
	public String getSensorName() {
		return pressureS.getSensorName();
	}

}
