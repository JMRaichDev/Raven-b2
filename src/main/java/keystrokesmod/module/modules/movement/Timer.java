//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.movement;

import keystrokesmod.main.NotAName;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings;
import keystrokesmod.module.ModuleSettings2;

public class Timer extends Module
{
    public static ModuleSettings2 a;
    public static ModuleSettings b;
    
    public Timer() {
        super(new char[] { 'T', 'i', 'm', 'e', 'r' }, category.movement, 0);
        Timer.a = new ModuleSettings2(new char[] { 'S', 'p', 'e', 'e', 'd' }, 1.0, 0.1, 3.0, 0.05);
        Timer.b = new ModuleSettings(new char[] { 'S', 't', 'r', 'a', 'f', 'e', ' ', 'O', 'n', 'l', 'y' }, false);
        this.registerSetting(Timer.a);
        this.registerSetting(Timer.b);
    }
    
    @Override
    public void update() {
        if (Timer.mc.currentScreen != NotAName.clickGui) {
            if (Timer.b.isToggled() && Timer.mc.thePlayer.moveStrafing == 0.0f) {
                ModuleHelper.rt();
                return;
            }
            ModuleHelper.gt().timerSpeed = (float) Timer.a.getInput();
        }
        else {
            ModuleHelper.rt();
        }
    }
    
    @Override
    public void onDisable() {
        ModuleHelper.rt();
    }
}
