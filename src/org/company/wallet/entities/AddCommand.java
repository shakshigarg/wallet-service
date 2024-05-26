package org.company.wallet.entities;

public class AddCommand extends Command {
    DeviceType deviceType;
    String deviceId;

    public AddCommand() {
        super(CommandType.ADD);
    }
}
