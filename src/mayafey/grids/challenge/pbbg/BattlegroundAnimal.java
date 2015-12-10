package mayafey.grids.challenge.pbbg;

import java.util.Random;

import mayafey.grids.data.GridReader;
import mayafey.grids.data.GridView;

public abstract class BattlegroundAnimal extends Animal {
	
	protected int[] pos = new int[2];
	
	protected int resistance;
	protected int vision;
	protected int weight;
	
	protected final Random random;
	protected final GridReader reader;
	
	public BattlegroundAnimal(GridReader reader, Random rand)
	{
		this.reader = reader;
		this.random = rand;
	}
	
	public void damage(int damage)
	{
		damage *= 100;
		damage /= 50 + random.nextInt(151);
		damage *= 100 - resistance;
		damage /= 100;
		this.health -= damage;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public int getResistance()
	{
		return this.resistance;
	}
	
	public final int getVision()
	{
		return this.vision;
	}
	
	public abstract boolean defend(String animal);
	public abstract void tick();
	public abstract int attack();
	public abstract int getSpeed();
	public abstract int getMove(GridView<String> view);
	
	public final Random getRandom()
	{
		return this.random;
	}
	
	public int[] getPosition()
	{
		return this.pos;
	}
	
	public final int getX()
	{
		return pos[0];
	}
	
	public final int getY()
	{
		return pos[1];
	}
	
	public final int distanceFrom(int x, int y)
	{
		return reader.distanceFrom(pos[0], x, pos[1], y);
	}

}
