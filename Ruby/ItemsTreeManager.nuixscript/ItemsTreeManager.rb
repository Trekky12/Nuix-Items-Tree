script_directory = File.dirname(__FILE__)
require File.join(script_directory,"NuixItemsTree.jar")

java_import 'gui.MainFrame'


m = MainFrame.new($current_case)
m.setVisible(true)

