//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.render;

import keystrokesmod.render.RenderUtils;
import keystrokesmod.module.modules.client.SelfDestruct;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings;
import keystrokesmod.module.ModuleSettings2;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.Color;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class ChestESP extends Module
{
    public static ModuleSettings2 red;
    public static ModuleSettings2 green;
    public static ModuleSettings2 blue;
    public static ModuleSettings rainbow;
    
    public ChestESP() {
        super(new char[] { 'C', 'h', 'e', 's', 't', 'E', 'S', 'P' }, category.render, 0);
        ChestESP.red = new ModuleSettings2(new char[] { 'R', 'e', 'd' }, 0.0, 0.0, 255.0, 1.0);
        ChestESP.green = new ModuleSettings2(new char[] { 'G', 'r', 'e', 'e', 'n' }, 0.0, 0.0, 255.0, 1.0);
        ChestESP.blue = new ModuleSettings2(new char[] { 'B', 'l', 'u', 'e' }, 255.0, 0.0, 255.0, 1.0);
        ChestESP.rainbow = new ModuleSettings(new char[] { 'R', 'a', 'i', 'n', 'b', 'o', 'w' }, false);
        this.registerSetting(ChestESP.red);
        this.registerSetting(ChestESP.green);
        this.registerSetting(ChestESP.blue);
        this.registerSetting(ChestESP.rainbow);
    }
    
    @SubscribeEvent
    public void o(final RenderWorldLastEvent ev) {
        if (!ModuleHelper.e() || SelfDestruct.isDestructed) {
            return;
        }
        for (final TileEntity te : ChestESP.mc.theWorld.loadedTileEntityList) {
            if (te instanceof TileEntityChest || te instanceof TileEntityEnderChest) {
                int rgb = 0;
                if (!ChestESP.rainbow.isToggled()) {
                    rgb = new Color((int) ChestESP.red.getInput(), (int) ChestESP.green.getInput(), (int) ChestESP.blue.getInput()).getRGB();
                }
                else {
                    float hue = (float)((System.currentTimeMillis() - 15L) % 6000L);
                    hue /= 6000.0f;
                    rgb = Color.getHSBColor(hue, 1.0f, 1.0f).getRGB();
                }
                RenderUtils.re(te.getPos(), rgb);
            }
        }
    }
    
    @Override
    public void update() {
    }
}
