package tools;

public class AnimationBuffer {

	private int[] ids;
	private float time;
	private long pastTime;
	private int index, cycles;
	private boolean fix;
	
	/**
	 * @param ids list of sprite id's
	 * @param time is seconds 
	 */
	public AnimationBuffer(int[] ids, float time) {
		this.ids = ids;
		this.time = time;
		index = 0;
		pastTime = 0;
		fix = false;
	}
	
	public int update() {
		if(!fix) {
			fix = true;
			pastTime = System.currentTimeMillis();
		}
		if(System.currentTimeMillis() - pastTime >= time * 1000) {
			pastTime = System.currentTimeMillis();
			index++;
		}
		if(index == ids.length) {
			index = 0;
			cycles++;
		}
		return ids[index];
	}
	
	public int getCycles() {
		return cycles;
	}
}
