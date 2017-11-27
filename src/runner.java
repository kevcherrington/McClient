import java.net.Inet4Address;
import java.net.InetSocketAddress;

public class runner {
    public static void main(String[] args) throws Exception {
        ServerListPing17 ping = new ServerListPing17();
        ping.setAddress(new InetSocketAddress(Inet4Address.getByName("chermc.ddns.net"), 1433));
        ServerListPing17.StatusResponse res = ping.fetchData();
        System.out.println("MOTD: " + res.getDescription().getText());
        System.out.println("Players: " + res.getPlayers().getOnline()+"/"+res.getPlayers().getMax());
        if (res.getPlayers().getSample() != null) {
            for (ServerListPing17.Player p : res.getPlayers().getSample()) {
                System.out.println("Player: " + p.getName());
            }
        }
        System.out.println("Minecraft Version: "+res.getVersion().getName());
        System.out.println("Mods:");
        for (ServerListPing17.Mod mod : res.getModinfo().getModList()) {
            System.out.println("-"+mod.getModid()+" v:"+mod.getVersion());
        }

    }
}
