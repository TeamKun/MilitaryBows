package net.kunmc.lab.militarybows.command;

import dev.kotx.flylib.command.Command;

import dev.kotx.flylib.command.CommandContext;
import java.util.ArrayList;
import java.util.List;
import net.kunmc.lab.militarybows.bow.BowsMeta;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Give extends Command {

  public Give(@NotNull CommandEnum commandEnum) {
    super(commandEnum.name().toLowerCase());

    for (BowsMeta bowsMeta : BowsMeta.values()) {
      children(new bow(bowsMeta));
    }
  }

  class bow extends Command {
    private BowsMeta bowsMeta;
    public bow(@NotNull BowsMeta bowsMeta) {
      super(bowsMeta.name().toLowerCase());
      this.bowsMeta = bowsMeta;
      usage(usageBuilder -> {
        usageBuilder.entityArgument("player");
      });
    }

    @Override
    public void execute(@NotNull CommandContext ctx) {
      if (ctx.getArgs().size() == 0) {
        ctx.getPlayer().getInventory().addItem(createBow());
        return;
      }


      List targetList = (List) ctx.getTypedArgs().get(0);
      for (Object target : targetList) {
        if (target instanceof Player) {
          ((Player) target).getInventory().addItem(createBow());
        }
      }
    }

    private ItemStack createBow() {
      ItemStack itemStack = new ItemStack(Material.CROSSBOW);
      ItemMeta meta = itemStack.getItemMeta();
      meta.setDisplayName(this.bowsMeta.bowName());
      itemStack.setItemMeta(meta);

      List<Component> lore = new ArrayList<>();
      lore.add(Component.text(this.bowsMeta.magazineCapacity()));
      itemStack.lore(lore);
      return itemStack;
    }
  }
}
