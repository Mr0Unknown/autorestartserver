package serverplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;

/**
 * Main Class
 *
 * @author MrUnknown
 * @date 2019/5/3
 */
public class Main extends JavaPlugin{
    private JavaPlugin plugin;
    private BukkitTask restart;
    private FileConfiguration config;
    public int s;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("autorestartreload")){
            if(!sender.hasPermission("autorestartserver.reload")){
                sender.sendMessage("§c你没有权限这么做");
                return true;
            }
            else {
                try {
                    this.reloadConfig();
                    this.config = this.getConfig();
                    this.s = config.getInt("seconds");
                    sender.sendMessage("§e配置文件重载成功");
                }
                catch (Exception e){
                    this.saveDefaultConfig();
                    sender.sendMessage("发生了点错误");
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void onEnable() {
        getLogger().info("已载入插件AutoReStartServer");
        File configfile = new File(this.getDataFolder(),"config.yml");
        //创建config配置文件
        if(!configfile.exists()){
            this.saveDefaultConfig();
            //若配置文件不存在则创建默认配置文件
        }
        this.reloadConfig();
        this.config = this.getConfig();
        this.s = config.getInt("seconds");
        this.restart = new BukkitRunnable() {
            @Override
            public void run() {
                s--;
                if (s == 0) {
                    Bukkit.getServer().broadcastMessage("开始重启");
                    Bukkit.shutdown();
                }
                if (s == 3600) {
                    Bukkit.getServer().broadcastMessage("服务器将在1小时后重启");
                }
                if (s == 300) {
                    Bukkit.getServer().broadcastMessage("服务器将在5分钟后重启");
                }
                if (s == 120) {
                    Bukkit.getServer().broadcastMessage("服务器将在2分钟后重启");
                }
                if (s == 60) {
                    Bukkit.getServer().broadcastMessage("服务器将在1分钟后重启");
                }
                if (s == 30) {
                    Bukkit.getServer().broadcastMessage("服务器将在30秒后重启");
                }
                if (s == 15) {
                    Bukkit.getServer().broadcastMessage("服务器将在15秒后重启");
                }
                if (s == 10) {
                    Bukkit.getServer().broadcastMessage("服务器将在10秒后重启");
                }
                if (s == 5) {
                    Bukkit.getServer().broadcastMessage("服务器将在5秒后重启");
                }
                if (s == 4) {
                    Bukkit.getServer().broadcastMessage("服务器将在4秒后重启");
                }
                if (s == 3) {
                    Bukkit.getServer().broadcastMessage("服务器将在3秒后重启");
                }
                if (s == 2) {
                    Bukkit.getServer().broadcastMessage("服务器将在2秒后重启");
                }
                if (s == 1) {
                    Bukkit.getServer().broadcastMessage("服务器将在1秒后重启");
                }
            }
        }.runTaskTimer(this, 0, 20);
        //定时器
    }

    @Override
    public void onDisable() {
        getLogger().info("已卸载插件AutoReStartServer");
        this.restart.cancel();
    }
}