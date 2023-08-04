package com.geektrust.backend.appConfig;

import com.geektrust.backend.commands.CommandInvoker;
import com.geektrust.backend.commands.CreateDriverCommand;
import com.geektrust.backend.commands.CreateRiderCommand;
import com.geektrust.backend.commands.ICommand;
import com.geektrust.backend.commands.MatchRiderAndDriversCommand;
import com.geektrust.backend.repositories.DriverRepository;
import com.geektrust.backend.repositories.IDriverRepository;
import com.geektrust.backend.repositories.IRiderRepository;
import com.geektrust.backend.repositories.RiderRepository;
import com.geektrust.backend.services.DriverService;
import com.geektrust.backend.services.IDriverService;
import com.geektrust.backend.services.IRiderService;
import com.geektrust.backend.services.RiderService;

public class ApplicationConfig {

    private final IRiderRepository riderRepository = new RiderRepository();
    private final IDriverRepository driverRepository = new DriverRepository();

    private final IRiderService riderService = new RiderService(riderRepository,driverRepository);
    private final IDriverService driverService = new DriverService(driverRepository);

    private final ICommand createRiderCommand = new CreateRiderCommand(riderService);
    private final ICommand createDriverCommand = new CreateDriverCommand(driverService);
    private final ICommand matchRiderAndDriversCommand = new MatchRiderAndDriversCommand(riderService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker() {
        commandInvoker.register("ADD_RIDER",createRiderCommand);
        commandInvoker.register("ADD_DRIVER",createDriverCommand);
        commandInvoker.register("MATCH",matchRiderAndDriversCommand);
        return commandInvoker;
    }

}
