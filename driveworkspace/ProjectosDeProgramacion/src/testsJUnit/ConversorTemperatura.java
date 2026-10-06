package testsJUnit;

public class ConversorTemperatura {

	// Celsius y Fahrenheit
	public static double celsiusAFahrenheit(double celsius) {
		return (celsius * 9 / 5) + 32;
	}

	public static double fahrenheitACelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5 / 9;
	}

	// Celsius y Kelvin
	public static double celsiusAKelvin(double celsius) {
		return celsius + 273.15;
	}

	public static double kelvinACelsius(double kelvin) {
		return kelvin - 273.15;
	}

	// Kelvin y Fahrenheit
	public static double kelvinAFahrenheit(double kelvin) {
		return (kelvin - 273.15) * 9 / 5 + 32;
	}

	public static double fahrenheitAKelvin(double fahrenheit) {
		return (fahrenheit - 32) * 5 / 9 + 273.15;
	}
}
