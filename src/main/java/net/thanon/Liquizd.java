package net.thanon;

import com.sun.net.httpserver.HttpServer;
import net.thanon.Bot.BotMain;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;

public class Liquizd {
    public static Dotenv config;
    public static void main(String args[]) {
        config = Dotenv.configure().load();
        System.out.println("Liquizd version: " + config.get("VERSION"));
        new BotMain();
    }
}
