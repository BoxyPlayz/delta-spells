package com.boxyplayz.deltaspells.client.gui;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;

public class TPBar {
	public static void extract(GuiGraphicsExtractor graphics, DeltaTracker tickCounter) {
		int yellow = 0xFFFFFF00; // Yellow
		int black = 0xFF000000; // Black

		Font font = Minecraft.getInstance().font;

		int width = font.width("100%") + 4;
		int height = font.lineHeight + 4;

		// Draw a square with the lerped color.
		// x1, x2, y1, y2, color
		graphics.fill(0, 0, width, height, yellow);

		graphics.text(font, "100%", 2, 2, black, false);
	}

}
