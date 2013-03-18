package org.neuschwabenland.emilspiel;

public class GameCamera {

	private float x = 0;
	private float targetX;
	private float minX, maxX;
	private float screenShakeAmplitude = 0.0f;
	private float screenShakeAnim = 0.0f;

	public GameCamera() {

	}

	private float clamp(float a, float min, float max) {
		if (a < min) {
			return min;
		}
		if (max < 0)
			return min;

		if (a > max) {
			return max;
		}
		return a;
	}

	public void update(int deltaMS) {

		x += (targetX - x) * (float) deltaMS * .01f;
		x = clamp(x, minX, maxX);

		screenShakeAnim += deltaMS * .001f;
		screenShakeAmplitude += -screenShakeAmplitude * deltaMS * .001f * 2.5f;
	}

	public float getX() {
		return (float) (Math.floor(x) + Math
				.cos(screenShakeAnim * Math.PI * 30) * screenShakeAmplitude);
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getViewX(float x) {
		return x + this.x;
	}

	public void setTargetX(float targetX) {
		this.targetX = targetX;
		targetX = clamp(targetX, minX, maxX);
	}

	public void setConstraints(float minX, float maxX) {
		this.minX = clamp(minX, 0, maxX);
		this.maxX = maxX;
	}

	public void centerOnConstraints() {
		this.x = this.targetX = minX + (maxX - minX) * .5f;
	}

	public void addScreenShake(float amount) {
		screenShakeAmplitude += amount;
	}
}
