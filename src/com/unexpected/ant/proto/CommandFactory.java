package com.unexpected.ant.proto;

public interface CommandFactory {
	Command createFromString(String s) throws CommandNotFoundException;
}
