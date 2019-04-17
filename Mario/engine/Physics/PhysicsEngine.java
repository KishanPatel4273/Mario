package Physics;

import objects.Entity;
import tools.*;
public class PhysicsEngine {
	
	private Frame frame;
	
	public PhysicsEngine(Frame frame) {
		this.frame = frame;
	}
	
	//see if making the method static is better
	
	//if not static add to engine(class:Engine)(package:render) check if physics applies then call method with said entity
	//if static add to update method in said Entity type (example:brick, Goomba, etc) with this as parameter
		//and make interface(for physics)(add to objects if needed) that will have gravity Vector(to have a time component)
			//make parameter be able to access the interface implements
	
	//call on method if Entity is in frame and physics apply to it.(such as AI, later fire balls, etc)
	public void checkPhysics(Entity e) {
		//run through all entities in frame(located in Engine.entities)
		//get distance from e and said entity(use ray casting or use colliders)
			//apply gravity if applicable
				//if applicable apply gravity if distance(Cast ray down) is > 2
				//add it as a function of time
			//if:(distance==2 they touch, less collide, more nothing
				//if d == 2 then tell e the side its being touched at. Note:might not need to do this, the might do the same function
				//if d < 2 they collide undo it and tell e(entity your checking) the direction of collision	
	}
}
