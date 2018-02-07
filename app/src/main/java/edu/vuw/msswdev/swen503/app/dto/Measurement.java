package edu.vuw.msswdev.swen503.app.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The DTO for each discrete point in time
 * 
 * @author cg
 *
 */
public class Measurement implements Comparable<Measurement> {

	private LocalDateTime timestamp;

	private List<Sensor> listSensors;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Measurement other = (Measurement) obj;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	/**
	 * enables ordering in time using Lists
	 */
	@Override
	public int compareTo(Measurement other) {
		return this.timestamp.compareTo(other.timestamp);
	}

	/**
	 * The DTO for each sensor
	 * 
	 * @author cg
	 *
	 */
	public static class Sensor {

		public Sensor(String sensorId) {
			this.sensorId = sensorId;
		}

		private String sensorId;

		private String description; // optional

		private Float reading;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((sensorId == null) ? 0 : sensorId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Sensor other = (Sensor) obj;
			if (sensorId == null) {
				if (other.sensorId != null)
					return false;
			} else if (!sensorId.equals(other.sensorId))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Sensor [Id=" + sensorId + ", Desc=" + description + ", Val=" + reading + "]";
		}

	}

}
