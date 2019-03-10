//Detials of competition.
public class CompetitionDetails
{
    public Guid _id { get; set; }
    public EventType Type { get; set; }
}

//Used to display competition dates on calander i.e. instance of competition
public class CompetitionInstance
{
    public Guid CompetitionDetailsId { get; set; }
    public DateTime StartTime { get; set; }
    public DateTime EndTime { get; set; }
    public List<Boat> ParticipatingBoats { get; set; }
    public Guid WinningCrewId {get;set;}
}

public enum EventType
{
    MotorPowerd = 0,
    WindPowerd = 1,
    ManPowerd = 2,
}