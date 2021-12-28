package net.kunmc.lab.militarybows.bow;

import net.kunmc.lab.configlib.value.IntegerValue;
import net.kunmc.lab.configlib.value.StringValue;
import net.kunmc.lab.militarybows.MilitaryBows;

public enum BowsMeta {
  ASSAULT(MilitaryBows.configManager.assaultConfig().name,
      MilitaryBows.configManager.assaultConfig().magazineCapacity);

  private StringValue bowName;
  private IntegerValue magazineCapacity;

  BowsMeta(StringValue bowName, IntegerValue magazineCapacity) {
    this.bowName = bowName;
    this.magazineCapacity = magazineCapacity;
  }

  public String bowName() {
    return this.bowName.value();
  }

  public int magazineCapacity() {
    return this.magazineCapacity.value();
  }
}
