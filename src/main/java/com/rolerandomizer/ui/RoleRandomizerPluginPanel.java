/*
 * Copyright (c) 2021-2022, Keano Porcaro <keano@ransty.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.rolerandomizer.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rolerandomizer.RoleRandomizerConfig;
import net.runelite.api.Client;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RoleRandomizerPluginPanel extends PluginPanel
{

        public RandomizeResultPanel resultPanel;
        public RoleRandomizerPanel inputPanel;

    public RoleRandomizerPluginPanel(Client client, RoleRandomizerConfig config, ChatMessageManager chatMessageManager)
        {
            super();

            inputPanel = new RoleRandomizerPanel(client,config, chatMessageManager, this);

            setLayout(new BorderLayout(5, 10));

            resultPanel = new RandomizeResultPanel(this);

            JButton clearButton = new JButton("Clear");
            clearButton.setBackground(ColorScheme.PROGRESS_ERROR_COLOR);
            clearButton.setBorder(new EmptyBorder(5, 7, 5, 7));
            clearButton.setToolTipText("This wipes the slate clean!");
            clearButton.addActionListener(e -> {
                inputPanel.cleanSlate();
                resultPanel.cleanSlate();
            });

            add(inputPanel, BorderLayout.NORTH);
            add(resultPanel, BorderLayout.CENTER);
            add(clearButton, BorderLayout.SOUTH);
        }
}
