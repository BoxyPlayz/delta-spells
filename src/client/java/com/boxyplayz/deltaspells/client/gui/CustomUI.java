package com.boxyplayz.deltaspells.client.gui;

import com.boxyplayz.deltaspells.DeltaSpells;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;

public class CustomUI {
	public static void extract(GuiGraphicsExtractor graphics, DeltaTracker tickCounter) {
		Minecraft minecraft = Minecraft.getInstance();

		if (minecraft.player == null) {
			return;
		}

		int yellow = 0xFFFFFF00; // Yellow
		int black = 0xFF000000; // Black
		int gray = 0xFFc9c9c7;

		Font font = minecraft.font;

		int width = font.width("TP: 100%") + 4;
		int height = font.lineHeight + 4;

		String text = "TP: " + minecraft.player.getAttachedOrElse(DeltaSpells.TP_ATTACHMENT, (byte) 0) + "%";

		graphics.fill(0, 0, width, height, yellow);

		graphics.text(font, text, 2, 2, black, false);

		graphics.fill(0, height, width, height + 40, gray);
	}

}
