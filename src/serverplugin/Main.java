package serverplugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;

/**
 * Main Class
 *
 * @author MrUnknown
 * @date 2019/5/3
 */
public class Main extends JavaPlugin{
    private JavaPlugin plugin;
    private FileConfiguration config;
    public int s;
    public Main(JavaPlugin plugin) {
        this.plugin = plugin;
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
        this.s = this.config.getInt("Numbers.Seconds");
        new BukkitRunnable() {
            @Override
            public void run() {
                s--;
                if (s == 0) {
                    plugin.getServer().shutdown();
                }
                if (s == 3600) {
                    plugin.getServer().broadcastMessage("服务器将在1小时后重启");
                }
                if (s == 300) {
                    plugin.getServer().broadcastMessage("服务器将在5分钟后重启");
                }
                if (s == 120) {
                    plugin.getServer().broadcastMessage("服务器将在2分钟后重启");
                }
                if (s == 60) {
                    plugin.getServer().broadcastMessage("服务器将在1分钟后重启");
                }
                if (s == 30) {
                    plugin.getServer().broadcastMessage("服务器将在30秒后重启");
                }
                if (s == 15) {
                    plugin.getServer().broadcastMessage("服务器将在15秒后重启");
                }
                if (s == 10) {
                    plugin.getServer().broadcastMessage("服务器将在10秒后重启");
                }
                if (s == 55) {
                    plugin.getServer().broadcastMessage("服务器将在5秒后重启");
                }
                if (s == 4) {
                    plugin.getServer().broadcastMessage("服务器将在4秒后重启");
                }
                if (s == 3) {
                    plugin.getServer().broadcastMessage("服务器将在3秒后重启");
                }
                if (s == 2) {
                    plugin.getServer().broadcastMessage("服务器将在2秒后重启");
                }
                if (s == 1) {
                    plugin.getServer().broadcastMessage("服务器将在1秒后重启");
                }
            }
        }.runTaskTimer(this.plugin, 0, 20);
        //定时器
    }

    @Override
    public void onDisable() {
        getLogger().info("已卸载插件AutoReStartServer");
    }
}