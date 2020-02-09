/*
 * Copyright 2020 Test Team Pls Ignore.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ttpi.new_world_journey;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.ttpi.new_world_journey.commands.Start;
import org.ttpi.new_world_journey.engine.Engine;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class Main {
    public static void main(String[] args) throws LoginException {
        EventWaiter waiter = new EventWaiter();
        CommandClientBuilder client = new CommandClientBuilder();
        client.setEmojis("\uD83D\uDE03", "\uD83D\uDE2E", "\uD83D\uDE26");
        client.setPrefix("!");
        client.addCommands(new Start(waiter));
        client.setOwnerId("275473481108291584");
        client.setCoOwnerIds("288133633552809984");
        client.setCoOwnerIds("174511937151827969");
        new JDABuilder(AccountType.BOT)
                .setToken("Njc1NzY0NDI2MTIwMzY0MDMz.Xj-MDw.wZ7p-6IrLfUxygIIa0aFoLychik")
                .setActivity(Activity.playing("loading..."))
                .addEventListeners(waiter, client.build())
                .build();
    }
}
