package com.unexpected.ant;

import com.unexpected.ant.proto.*;
import com.unexpected.ant.proto.command.ExitRequestedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	CommandResolver commandResolver;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		commandResolver = new CommandResolverImpl(new CommandFactoryImpl(new GameContext()));
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		try {
			while (true) {

				try {
					Command command = commandResolver.resolve(in.readLine());
					command.execute();
				} catch (CommandNotFoundException e) {
					System.out.println("Nem létező parancs");
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParameterNotFoundException e) {
					System.out.println("Paraméter hiányzik: " + e.getParameterName());
				}
			}
		} catch (ExitRequestedException exit) {

		}
	}

}
