public class Crew
{
    public Guid _id { get; set; }
    public Guid BoatId { get; set; }
    public string CrewName { get; set; }
    public List<CrewMemebr> CrewMembers { get; set; }
}

public class CrewMember
{
    public Guid _id { get; set; }
    public string Name { get; set; }
    public string Role { get; set; }
}