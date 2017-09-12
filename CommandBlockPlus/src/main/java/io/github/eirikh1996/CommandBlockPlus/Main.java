package io.github.eirikh1996.CommandBlockPlus;

import org.bukkit.command.BlockCommandSender;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    @Override
    public void onEnable() {
        // TODO Insert logic to be performed when the plugin is enabled
    }
    
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }
    private Player player;
    public boolean onCommand(CommandSender sender,Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("cbplus") || cmd.getName().equalsIgnoreCase("cbp") || cmd.getName().equalsIgnoreCase("cp")) {
			String name = sender.getName();
			int x = 0;
			int y = 0;
			int z = 0;
			boolean haspos = false;
			World world = null;
			if (sender instanceof Player) {
				if (!(player.hasPermission("commandblockplus.cbplus"))) {
					player.sendMessage("You are not permitted to use this command");
					return false;
				} else {
					sender.sendMessage(ChatColor.DARK_GREEN + "=============" + ChatColor.AQUA + "COMMANDBLOCK PLUS" + ChatColor.DARK_GREEN + "=============");
					sender.sendMessage(ChatColor.BLUE + "A plugin that allows player-only commands to be run through command blocks. Good for using plugins like WorldEdit and Movecraft with command blocks");
					sender.sendMessage(ChatColor.LIGHT_PURPLE + "Github:");
					sender.sendMessage(ChatColor.LIGHT_PURPLE + "Discord:");
					sender.sendMessage(ChatColor.LIGHT_PURPLE + "Spigot page:");
					sender.sendMessage(ChatColor.LIGHT_PURPLE + "Version:");
					sender.sendMessage(ChatColor.BLUE + "Usage in command blocks: /cp -w [world] -p [playername] -l [x] [y] [z] [command] [args]");
						return false;
					}
				}
			
			if (sender instanceof BlockCommandSender) {
				Block cmdblock = ((BlockCommandSender)sender).getBlock();
				x = cmdblock.getLocation().getBlockX();
				y = cmdblock.getLocation().getBlockY();
				z = cmdblock.getLocation().getBlockZ();
				world = cmdblock.getLocation().getWorld();
				haspos = true;
			}
		}
    	return false;
    	
    }
}
