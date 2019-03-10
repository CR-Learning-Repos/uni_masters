public class Boat
{
    public Guid _id { get; set; }
    public EventType Type { get; set; }
    public abstract float Speed { get; set; }
}

public class SpeedBoat : Boat
{
    public override float Speed { get; set; }
}
public class SailBoat : Boat
{
    public override float Speed { get; set; }
}
public class RowBoat : Boat
{
    public override float Speed { get; set; }
}