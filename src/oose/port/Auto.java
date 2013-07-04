package oose.port;

public class Auto {
	
	private Motor motor = new Motor();
	
	private class Motor {
		public void motor_ein() {
			System.out.println("Motor ein");
		}

		public void motor_aus() {
			System.out.println("Motor aus");
		}
	}

	/**
	 * Service Port
	 * @author markusklink
	 *
	 */
	class MotorPort implements Ein, Aus {
		
		public void ein() {
			Auto.this.motor.motor_ein();
		}

		public void aus() {
			Auto.this.motor.motor_aus();
		}
	}

	/**
	 * Behaviour Port
	 * @author markusklink
	 *
	 */
	class LichtPort implements Ein, Aus {

		public void ein() {
			Auto.this.licht_ein();
		}

		public void aus() {
			Auto.this.licht_aus();
		}
	}

	interface Ein {
		void ein();
	}

	interface Aus {
		void aus();
	}

	public final MotorPort motorPort = new MotorPort();

	public final LichtPort lichtPort = new LichtPort();

	public Auto() {
	
	}

	private void licht_ein() {
		System.out.println("Licht ein");
	}

	private void licht_aus() {
		System.out.println("Licht aus");
	}

	public static void main(String[] args) {
		Auto auto = new Auto();
		

		MotorPort mPort = auto.motorPort;

		mPort.ein();

	}

}
