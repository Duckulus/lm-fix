package de.duckulus.labydojofix;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = LabyDojoFix.MOD_ID, name = LabyDojoFix.MOD_NAME, version = LabyDojoFix.MOD_VERSION, clientSideOnly = true)
public class LabyDojoFix {

    public static final String MOD_NAME = "LabyDojoFix";
    public static final String MOD_ID = "labydojofix";
    public static final String MOD_VERSION = "1.0";

    public static Logger LOGGER = LogManager.getLogger();

    @Mod.Instance(LabyDojoFix.MOD_ID)
    private static LabyDojoFix instance;


    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        System.out.println("Hello World");
    }

    public static LabyDojoFix getInstance() {
        return instance;
    }

}
