public class Character extends Entity
{
	public boolean canMove(Map m, int nx, int ny)
	{
		return (!(m.map[nx][ny] instanceof terrain) && (nx < m.map.length && nx >= 0) && (m.map[nx].length > ny && ny >= 0));
	}

	public void move(int nx, int ny)
	{
		if (canMove(nx, ny))
			m.map[nx][ny] = this;
	}
}