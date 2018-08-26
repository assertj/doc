package example.data;

public class TolkienCharacter {

  public static TolkienCharacter of(String name, Integer age, Race race) {

    return new TolkienCharacter(name, age, race);
  }

  public enum Race {
    HOBBIT, MAIA, ELF, DWARF, MAN
  }

  public final String name;
  public final Integer age;
  public final Race race;

  private TolkienCharacter(String name, Integer age, Race race) {

    this.name = name;
    this.age = age;
    this.race = race;
  }

  public String getName() {

    return name;
  }

  public Integer getAge() {

    return age;
  }

  public Race getRace() {

    return race;
  }

  @Override
  public String toString() {
    return String.format("TolkienCharacter [name=%s, age=%s, race=%s]", name, age, race);
  }

}
