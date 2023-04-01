package net.thanon;

import net.thanon.Bot.BotMain;
import io.github.cdimascio.dotenv.Dotenv;

public class Liquizd {
    public static Dotenv config;
    //MTA5MDk4MTI4MTI0MTc3MjExMg.GqPIAN._foKE-IOCYjQlnAmyp7TuuvSdmqvU3_Sr-Ary0
    public static void main(String args[]) {
        config = Dotenv.configure().load();
        System.out.println("Liquizd version: " + config.get("VERSION"));
        try {
            new BotMain();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
