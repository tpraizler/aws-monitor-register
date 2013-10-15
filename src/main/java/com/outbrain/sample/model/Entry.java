package com.outbrain.sample.model;

public class Entry {

		private String agent;
		private InitParameters initParameters;
		private MetaData metadata;
		private String mountPoint;
		private String script;
		
		public String getAgent() {
			return agent;
		}
		public void setAgent(String agent) {
			this.agent = agent;
		}
		public InitParameters getInitParameters() {
			return initParameters;
		}
		public void setInitParameters(InitParameters initParameters) {
			this.initParameters = initParameters;
		}
		public MetaData getMetadata() {
			return metadata;
		}
		public void setMetadata(MetaData metadata) {
			this.metadata = metadata;
		}
		public String getMountPoint() {
			return mountPoint;
		}
		public void setMountPoint(String mountPoint) {
			this.mountPoint = mountPoint;
		}
		public String getScript() {
			return script;
		}
		public void setScript(String script) {
			this.script = script;
		}
}
