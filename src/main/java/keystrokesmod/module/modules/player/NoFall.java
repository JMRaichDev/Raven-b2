//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.player;

import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleDesc;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings2;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;

public class NoFall extends Module
{
    public static ModuleSettings2 mode;
    public static ModuleDesc moduleDesc;
    
    public NoFall() {
        super(new char[] { 'N', 'o', 'F', 'a', 'l', 'l' }, category.player, 0);
        NoFall.mode = new ModuleSettings2(new char[] { 'M', 'o', 'd', 'e' }, 1.0, 1.0, 2.0, 1.0);
        NoFall.moduleDesc = new ModuleDesc(ModuleHelper.c + "Packet");
        this.registerSetting(NoFall.mode);
        this.registerSetting(NoFall.moduleDesc);
    }
    
    @Override
    public void update() {
        if (NoFall.mode.getInput() == 1.0) {
            if (NoFall.mc.thePlayer.fallDistance > 2.5) {
                NoFall.mc.thePlayer.fallDistance = 0.0f;
                NoFall.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C03PacketPlayer(true));
            }
        }
        else if (NoFall.mode.getInput() == 2.0 && NoFall.mc.thePlayer.fallDistance > 2.5 && !NoFall.mc.thePlayer.isOnLadder() && !NoFall.mc.thePlayer.isInWater() && !NoFall.mc.thePlayer.isInLava()) {
            NoFall.mc.thePlayer.motionY = -6.0;
        }
    }
    
    @Override
    public void guiUpdate() {
        if (NoFall.mode.getInput() == 1.0) {
            NoFall.moduleDesc.setDesc(ModuleHelper.c + "Packet");
        }
        else if (NoFall.mode.getInput() == 2.0) {
            NoFall.moduleDesc.setDesc(ModuleHelper.c + "Motion");
        }
    }
}
