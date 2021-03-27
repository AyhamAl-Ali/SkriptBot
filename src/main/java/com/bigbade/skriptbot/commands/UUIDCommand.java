package com.bigbade.skriptbot.commands;

import lombok.Getter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import com.bigbade.skriptbot.api.ICommand;
import com.bigbade.skriptbot.utils.MessageUtils;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UUIDCommand implements ICommand {
    public static final EmbedBuilder UUID_EMBED = new EmbedBuilder().setTitle("UUIDs in variables")
            .setColor(Color.green).addField(new MessageEmbed.Field("Why?",
                    "UUIDs are the best way to store player info, as a player's UUID will never "
                            + "change, whereas their name can. UUIDs can be used for any type of variable, in the "
                            + "same way as `%player%` is. Your player's money/stats can be lost if they change their in "
                            + "game name when `%player%` is used.", false))
            .addField(new MessageEmbed.Field("How to use",
                    "You use this in the same was as using `%player%`, just with "
                            + "`'s uuid` on the end, so `player's uuid`!", false))
            .addField(new MessageEmbed.Field("Common situations which can use UUID's instead",
                    "```yaml\n" +
                            "{stats::%player%::kills} -> {stats::%player's uuid%::kills}\n"
                            + "{vanish::%player%} -> {vanish::%uuid of player%}\n"
                            + "{generator::%player%::*} -> {generator::%player's uuid%::*}```", false))
            .addField(new MessageEmbed.Field("Extra Notes",
                    "There is currently an issue where you cannot use `{var::%{_p}'s uuid%}` in functions, "
                            + "a workaround this is to use something similar to this: "
                            + "```vb\n"
                            + "function addKill(p: player):\n"
                            + "   set {_u} to {_p}'s uuid\n"
                            + "   add 1 to {stats::%{_u}%::kills}```", false));
    @Getter
    private final List<String> aliases = Collections.unmodifiableList(Arrays.asList("uuid", "uuids"));

    @Override
    public void onCommand(Message message, String[] args) {
        MessageUtils.sendEmbedWithReaction(message.getTextChannel(), new EmbedBuilder(UUID_EMBED).setFooter("UUID | "
                + message.getId()).build());
    }
}
